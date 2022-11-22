package user_unit_test.login;

import org.junit.Test;
import ds.user_login_ds.UserLoginDataBaseGateway;
import ds.user_login_ds.UserLoginFileGateway;
import ds.user_reg_ds.UserRegisterDataBaseGateway;
import ds.user_reg_ds.UserRegisterFileGateway;
import abr.user_login_abr.UserLogOutputBoundary;
import abr.user_login_abr.UserLogRequestModel;
import abr.user_login_abr.UserLogUseCase;
import interface_adaptors.user_login_screen.UserLogPresenter;
import interface_adaptors.user_login_screen.UserLogViewModel;
import abr.user_reg_abr.UserRegOutputBoundary;
import abr.user_reg_abr.UserRegRequestModel;
import abr.user_reg_abr.UserRegUseCase;
import interface_adaptors.user_reg_screen.UserRegPresenter;

import java.util.HashMap;
import java.util.Map;

public class UserLogUseCaseUnitTest {
    public UserLogUseCase initialize(){
        // Initialzie User register part
        UserRegisterDataBaseGateway dataBaseGateway = new UserRegisterFileGateway();
        dataBaseGateway.clearDatabase();
        UserRegOutputBoundary boundary = new UserRegPresenter();
        UserRegUseCase userRegUseCase =  new UserRegUseCase(boundary, dataBaseGateway);

        // Register a sample User
        Map<String, String> securityQuestionMap= new HashMap<>();
        securityQuestionMap.put("1","2");
        UserRegRequestModel requestModel = new UserRegRequestModel("111","222","111",securityQuestionMap);
        userRegUseCase.register(requestModel);

        // Initialize User Login Part
        UserLoginDataBaseGateway dataBaseGateway1 = new UserLoginFileGateway();
        UserLogOutputBoundary boundary1 = new UserLogPresenter();
        return new UserLogUseCase(boundary1, dataBaseGateway1);

    }

    @Test
    public void TestCorrectUserNameAndPassword(){
        UserLogUseCase useCase = initialize();
        UserLogRequestModel requestModel = new UserLogRequestModel("222", "111");
        UserLogViewModel pak = useCase.loginUser(requestModel);
        assert pak.isValidUserName();
        assert pak.isUserPasswordValid();
    }

    @Test
    public void TestWrongPassword(){
        UserLogUseCase useCase = initialize();
        UserLogRequestModel requestModel = new UserLogRequestModel("222","222");
        UserLogViewModel pak = useCase.loginUser(requestModel);
        assert !pak.isUserPasswordValid();
        assert pak.isValidUserName();
    }

    @Test
    public void TestWrongUserName(){
        UserLogUseCase useCase = initialize();
        UserLogRequestModel requestModel = new UserLogRequestModel("000","111");
        UserLogViewModel pak = useCase.loginUser(requestModel);
        assert !pak.isUserPasswordValid();
        assert !pak.isValidUserName();
    }
}

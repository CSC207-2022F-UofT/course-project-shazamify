package user.unit_test.login;

import org.junit.Test;
import user.database.UserLoginDataBaseGateway;
import user.database.UserLoginFileGateway;
import user.database.UserRegisterDataBaseGateway;
import user.database.UserRegisterFileGateway;
import user.entities.UserSecurityQuestionPackage;
import user.login.abr.UserLogOutputBoundary;
import user.login.abr.UserLogRequestModel;
import user.login.abr.UserLogUseCase;
import user.login.screen.UserLogPresenter;
import user.login.screen.UserLogViewModel;
import user.reg.abr.UserRegOutputBoundary;
import user.reg.abr.UserRegRequestModel;
import user.reg.abr.UserRegUseCase;
import user.reg.screen.UserRegPresenter;

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

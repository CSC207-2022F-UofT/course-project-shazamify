package user.unit_test.login;

import org.junit.Test;
import user.database.UserLoginDataBaseGateway;
import user.database.UserLoginFileGateway;
import user.database.UserRegisterDataBaseGateway;
import user.database.UserRegisterFileGateway;
import user.login.abr.UserLogOutputBoundary;
import user.login.abr.UserLogRequestModel;
import user.login.abr.UserLogUseCase;
import user.login.screen.UserLogPresenter;
import user.login.screen.UserLogViewModel;

public class UserLogUseCaseUnitTest {
    @Test
    public void TestCorrectUserNameAndPassword(){
        UserLoginDataBaseGateway dataBaseGateway = new UserLoginFileGateway();
        UserRegisterDataBaseGateway registerGateway = new UserRegisterFileGateway();
        UserLogOutputBoundary outputBoundary = new UserLogPresenter();
        UserLogRequestModel requestModel = new UserLogRequestModel("111","222");
        UserLogUseCase useCase = new UserLogUseCase(outputBoundary,dataBaseGateway);
        dataBaseGateway.clearDatabase();
        registerGateway.checkAndRegisterUser("111", "222");
        UserLogViewModel pak = useCase.loginUser(requestModel);
        assert pak.isValidUserName();
        assert pak.isUserPasswordValid();
    }

    @Test
    public void TestWrongPassword(){
        UserLoginDataBaseGateway dataBaseGateway = new UserLoginFileGateway();
        UserRegisterDataBaseGateway registerGateway = new UserRegisterFileGateway();
        UserLogOutputBoundary outputBoundary = new UserLogPresenter();
        UserLogRequestModel requestModel = new UserLogRequestModel("111","222");
        UserLogUseCase useCase = new UserLogUseCase(outputBoundary,dataBaseGateway);
        dataBaseGateway.clearDatabase();
        registerGateway.checkAndRegisterUser("111", "333");
        UserLogViewModel pak = useCase.loginUser(requestModel);
        assert !pak.isUserPasswordValid();
        assert pak.isValidUserName();
    }

    @Test
    public void TestWrongUserName(){
        UserLoginDataBaseGateway dataBaseGateway = new UserLoginFileGateway();
        UserRegisterDataBaseGateway registerGateway = new UserRegisterFileGateway();
        UserLogOutputBoundary outputBoundary = new UserLogPresenter();
        UserLogRequestModel requestModel = new UserLogRequestModel("111","222");
        UserLogUseCase useCase = new UserLogUseCase(outputBoundary,dataBaseGateway);
        dataBaseGateway.clearDatabase();
        registerGateway.checkAndRegisterUser("3333", "222");
        UserLogViewModel pak = useCase.loginUser(requestModel);
        assert !pak.isUserPasswordValid();
        assert !pak.isValidUserName();
    }
}

package user.unit_test.login;

import org.junit.Test;
import user.database.UserDataBaseGateway;
import user.database.UserFileGateway;
import user.login.abr.UserLogOutputBoundary;
import user.login.abr.UserLogRequestModel;
import user.login.abr.UserLogUseCase;
import user.login.screen.UserLogPresenter;
import user.login.screen.UserLogViewModel;

public class UserLogUseCaseUnitTest {
    @Test
    public void TestCorrectUserNameAndPassword(){
        UserDataBaseGateway dataBaseGateway = new UserFileGateway();
        UserLogOutputBoundary outputBoundary = new UserLogPresenter();
        UserLogRequestModel requestModel = new UserLogRequestModel("111","222");
        UserLogUseCase useCase = new UserLogUseCase(outputBoundary,dataBaseGateway);
        dataBaseGateway.clearDatabase();
        dataBaseGateway.checkAndRegisterUser("111", "222");
        UserLogViewModel pak = useCase.loginUser(requestModel);
        assert pak.isValidUserName();
        assert pak.isUserPasswordValid();
    }

    @Test
    public void TestWrongPassword(){
        UserDataBaseGateway dataBaseGateway = new UserFileGateway();
        UserLogOutputBoundary outputBoundary = new UserLogPresenter();
        UserLogRequestModel requestModel = new UserLogRequestModel("111","222");
        UserLogUseCase useCase = new UserLogUseCase(outputBoundary,dataBaseGateway);
        dataBaseGateway.clearDatabase();
        dataBaseGateway.checkAndRegisterUser("111", "333");
        UserLogViewModel pak = useCase.loginUser(requestModel);
        assert !pak.isUserPasswordValid();
        assert pak.isValidUserName();
    }

    @Test
    public void TestWrongUserName(){
        UserDataBaseGateway dataBaseGateway = new UserFileGateway();
        UserLogOutputBoundary outputBoundary = new UserLogPresenter();
        UserLogRequestModel requestModel = new UserLogRequestModel("111","222");
        UserLogUseCase useCase = new UserLogUseCase(outputBoundary,dataBaseGateway);
        dataBaseGateway.clearDatabase();
        dataBaseGateway.checkAndRegisterUser("3333", "222");
        UserLogViewModel pak = useCase.loginUser(requestModel);
        assert !pak.isUserPasswordValid();
        assert !pak.isValidUserName();
    }
}

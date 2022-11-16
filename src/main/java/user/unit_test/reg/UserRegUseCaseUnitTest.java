package user.unit_test.reg;

import org.junit.Test;
import user.database.UserRegisterDataBaseGateway;
import user.database.UserRegisterFileGateway;
import user.reg.abr.UserRegOutputBoundary;
import user.reg.abr.UserRegRequestModel;
import user.reg.abr.UserRegUseCase;
import user.reg.screen.UserRegPresenter;
import user.reg.screen.UserRegViewModel;

public class UserRegUseCaseUnitTest {
    @Test
    public void passWordAndRepassWordNotMatch(){
        UserRegisterDataBaseGateway dataBaseGateway = new UserRegisterFileGateway();
        dataBaseGateway.clearDatabase();
        UserRegOutputBoundary boundary = new UserRegPresenter();
        UserRegUseCase userRegUseCase = new UserRegUseCase(boundary, dataBaseGateway);
        UserRegRequestModel requestModel = new UserRegRequestModel("qazwsx741","1404528381","qazwsx741");
        UserRegViewModel viewModel = userRegUseCase.register(requestModel);
        assert viewModel.isPasswordValid();
    }

    @Test
    public void userNameAlreadyExists(){
        UserRegisterDataBaseGateway dataBaseGateway = new UserRegisterFileGateway();
        dataBaseGateway.clearDatabase();
        UserRegOutputBoundary boundary = new UserRegPresenter();
        UserRegUseCase userRegUseCase = new UserRegUseCase(boundary, dataBaseGateway);
        UserRegRequestModel requestModel = new UserRegRequestModel("qazwsx741","140452838","qazwsx741");
        userRegUseCase.register(requestModel);
        // Register the requestModel 2nd times
        UserRegViewModel viewModel2 = userRegUseCase.register(requestModel);
        assert !viewModel2.isUsernameValid();
    }
}

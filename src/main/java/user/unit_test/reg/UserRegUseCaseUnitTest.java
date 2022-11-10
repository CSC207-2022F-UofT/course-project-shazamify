package user.unit_test.reg;

import org.junit.Test;
import user.database.UserDataBaseGateway;
import user.database.UserFileGateway;
import user.reg.abr.UserRegOutputBoundary;
import user.reg.abr.UserRegRequestModel;
import user.reg.abr.UserRegUseCase;
import user.reg.screen.UserRegPresenter;
import user.reg.screen.UserRegViewModel;

public class UserRegUseCaseUnitTest {
    @Test
    public void passWordAndRepassWordNotMatch(){
        UserDataBaseGateway dataBaseGateway = new UserFileGateway();
        UserRegOutputBoundary boundary = new UserRegPresenter();
        UserRegUseCase userRegUseCase = new UserRegUseCase(boundary, dataBaseGateway);
        UserRegRequestModel requestModel = new UserRegRequestModel("qazwsx741","1404528381","qazwsx741");
        UserRegViewModel viewModel = userRegUseCase.register(requestModel);
        assert viewModel.isPasswordValid();
    }

    @Test
    public void userNameAlreadyExists(){
        UserDataBaseGateway dataBaseGateway = new UserFileGateway();
        UserRegOutputBoundary boundary = new UserRegPresenter();
        UserRegUseCase userRegUseCase = new UserRegUseCase(boundary, dataBaseGateway);
        UserRegRequestModel requestModel = new UserRegRequestModel("qazwsx741","140452838","qazwsx741");
        UserRegViewModel viewModel = userRegUseCase.register(requestModel);
        assert !viewModel.isUsernameValid();
    }
}

package user.unit_test.reg;

import org.junit.Test;
import user.reg.abr.UserRegOutputBoundary;
import user.reg.abr.UserRegRequestModel;
import user.reg.abr.UserRegUseCase;
import user.reg.screen.UserRegPresenter;
import user.reg.screen.UserRegViewModel;

import java.io.IOException;

public class UserRegUseCaseUnitTest {
    @Test
    public void passWordAndRepassWordNotMatch(){
        UserRegOutputBoundary boundary = new UserRegPresenter();
        UserRegUseCase userRegUseCase = new UserRegUseCase(boundary);
        UserRegRequestModel requestModel = new UserRegRequestModel("123123","140452838","qazwsx741");
        UserRegViewModel viewModel = userRegUseCase.register(requestModel);
        assert !viewModel.isPasswordValid();
    }

    @Test
    public void userNameAlreadyExists(){
        UserRegOutputBoundary boundary = new UserRegPresenter();
        UserRegUseCase userRegUseCase = new UserRegUseCase(boundary);
        UserRegRequestModel requestModel = new UserRegRequestModel("qazwsx741","140452838","qazwsx741");
        UserRegViewModel viewModel = userRegUseCase.register(requestModel);
        assert !viewModel.isUsernameValid();
    }
}

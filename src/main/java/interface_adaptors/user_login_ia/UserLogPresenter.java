package interface_adaptors.user_login_ia;

import abr.user_login_abr.UserLogOutputBoundary;
import abr.user_login_abr.UserLogResponseModel;

public class UserLogPresenter implements UserLogOutputBoundary {
    UserLogViewModel viewModel;

    public UserLogPresenter(UserLogViewModel viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void packageAndPresent(UserLogResponseModel responseModel) {
        this.viewModel.setValidUserName(responseModel.isValidUserName());
        this.viewModel.setUserPasswordValid(responseModel.isUserPasswordValid());
    }
}

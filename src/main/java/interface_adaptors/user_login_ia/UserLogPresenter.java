package interface_adaptors.user_login_ia;

import abr.user_login_abr.UserLogOutputBoundary;
import abr.user_login_abr.UserLogResponseModel;

public class UserLogPresenter implements UserLogOutputBoundary {

    @Override
    public UserLogViewModel packageAndPresent(UserLogResponseModel responseModel) {
        UserLogViewModel viewModel = new UserLogViewModel();
        viewModel.setValidUserName(responseModel.isValidUserName());
        viewModel.setUserPasswordValid(responseModel.isUserPasswordValid());
        return viewModel;
    }
}

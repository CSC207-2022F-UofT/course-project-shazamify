package user.login.screen;

import user.login.abr.UserLogOutputBoundary;
import user.login.abr.UserLogResponseModel;

public class UserLogPresenter implements UserLogOutputBoundary {

    @Override
    public UserLogViewModel packageAndPresent(UserLogResponseModel responseModel) {
        UserLogViewModel viewModel = new UserLogViewModel();
        viewModel.setValidUserName(responseModel.isValidUserName());
        viewModel.setUserPasswordValid(responseModel.isUserPasswordValid());
        return viewModel;
    }
}

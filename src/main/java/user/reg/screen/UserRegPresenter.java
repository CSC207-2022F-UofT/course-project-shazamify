package user.reg.screen;

import user.reg.abr.UserRegOutputBoundary;
import user.reg.abr.UserRegResponseModel;

public class UserRegPresenter implements UserRegOutputBoundary {
    @Override
    public UserRegViewModel packageAndPresent(UserRegResponseModel responseModel) {
        UserRegViewModel viewModel = new UserRegViewModel();
        viewModel.setPasswordValidity(responseModel.isPasswordValid());
        viewModel.setUsernameValidity(responseModel.isUsernameValid());
        viewModel.setRecommendPassword(responseModel.getRecommendPassword());
        viewModel.setSecurityQuestionValidity(responseModel.isSecurityQuestionValidity());
        return viewModel;
    }
}

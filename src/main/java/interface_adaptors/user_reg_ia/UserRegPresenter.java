package interface_adaptors.user_reg_ia;

import abr.user_reg_abr.UserRegOutputBoundary;
import abr.user_reg_abr.UserRegResponseModel;

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

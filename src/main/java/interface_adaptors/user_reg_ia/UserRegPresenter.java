package interface_adaptors.user_reg_ia;

import abr.user_reg_abr.UserRegOutputBoundary;
import abr.user_reg_abr.UserRegResponseModel;
import entities.user_entities.User;

public class UserRegPresenter implements UserRegOutputBoundary {
    UserRegViewModel regViewModel;
    public UserRegPresenter(){
        this.regViewModel = UserRegViewModel.getInstance();
    }
    @Override
    public void packageAndPresent(UserRegResponseModel responseModel) {
        regViewModel.setPasswordValidity(responseModel.isPasswordValid());
        regViewModel.setUsernameValidity(responseModel.isUsernameValid());
        regViewModel.setRecommendPassword(responseModel.getRecommendPassword());
        regViewModel.setSecurityQuestionValidity(responseModel.isSecurityQuestionValidity());
    }
}

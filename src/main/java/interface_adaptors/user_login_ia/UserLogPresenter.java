package interface_adaptors.user_login_ia;

import abr.user_login_abr.UserLogOutputBoundary;
import abr.user_login_abr.UserLogResponseModel;

/**
 * @author David Li
 */
public class UserLogPresenter implements UserLogOutputBoundary {
    UserLogViewModel logViewModel;
    UserStatusViewModel statusViewModel;

    public UserLogPresenter(UserLogViewModel logViewModel, UserStatusViewModel statusViewModel){
        this.logViewModel = logViewModel;
        this.statusViewModel = statusViewModel;
    }

    @Override
    public void packageAndPresent(UserLogResponseModel responseModel) {
        this.logViewModel.setValidUserName(responseModel.isValidUserName());
        this.logViewModel.setUserPasswordValid(responseModel.isUserPasswordValid());

        // If the account was created successfully, update status viewModel
        if (responseModel.isValidUserName() && responseModel.isUserPasswordValid() && responseModel.getUserName() != null){
            statusViewModel.setUserName(responseModel.getUserName());
            statusViewModel.setPassWord(responseModel.getPassWord());
            statusViewModel.setUserAvatar(responseModel.getUserAvatar());
            statusViewModel.setAccountCreateTime(responseModel.getAccountCreateTime());
            statusViewModel.setPlayListIds(responseModel.getPlayListIDs());
            statusViewModel.userUpdated();
        }
    }
}

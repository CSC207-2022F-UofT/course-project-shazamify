package interface_adaptors.user_avatar_image_management_ia;

import abr.user_avatar_image_management_abr.UserAvatarMngOutputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngResponseModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;

public class UserChangeMngPresenter implements UserAvatarMngOutputBoundary {
    UserAvatarMngViewModel avatarMngViewModel;
    UserStatusViewModel statusViewModel;

    public UserChangeMngPresenter(){
        this.avatarMngViewModel = UserAvatarMngViewModel.getInstance();
        this.statusViewModel = UserStatusViewModel.getInstance();
    }
    @Override
    public void packageAndPresent(UserAvatarMngResponseModel responseModel) {
        statusViewModel.setUserAvatar(responseModel.getUserAvatar());
        avatarMngViewModel.setDirectoryValid(responseModel.isDirectoryValid());
        statusViewModel.userUpdated();
    }
}

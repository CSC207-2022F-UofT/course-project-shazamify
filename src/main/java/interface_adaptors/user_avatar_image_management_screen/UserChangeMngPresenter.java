package interface_adaptors.user_avatar_image_management_screen;

import abr.user_avatar_image_management_abr.UserAvatarMngOutputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngResponseModel;

public class UserChangeMngPresenter implements UserAvatarMngOutputBoundary {
    UserAvatarMngViewModel viewModel = new UserAvatarMngViewModel();
    @Override
    public UserAvatarMngViewModel packageAndPresent(UserAvatarMngResponseModel responseModel) {
        viewModel.setDirectoryValid(responseModel.isDirectoryValid());
        viewModel.setUser(responseModel.getUser());
        return viewModel;
    }
}

package user.avatar_image_management.screen;

import user.avatar_image_management.abr.UserAvatarMngOutputBoundary;
import user.avatar_image_management.abr.UserAvatarMngResponseModel;

public class UserChangeMngPresenter implements UserAvatarMngOutputBoundary {
    UserAvatarMngViewModel viewModel = new UserAvatarMngViewModel();
    @Override
    public UserAvatarMngViewModel packageAndPresent(UserAvatarMngResponseModel responseModel) {
        viewModel.setDirectoryValid(responseModel.isDirectoryValid());
        viewModel.setUser(responseModel.getUser());
        return viewModel;
    }
}

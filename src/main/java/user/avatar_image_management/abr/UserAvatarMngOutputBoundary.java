package user.avatar_image_management.abr;

import user.avatar_image_management.screen.UserAvatarMngViewModel;

public interface UserAvatarMngOutputBoundary {
    UserAvatarMngViewModel packageAndPresent(UserAvatarMngResponseModel responseModel);
}

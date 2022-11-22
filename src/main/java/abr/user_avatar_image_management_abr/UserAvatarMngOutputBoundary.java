package abr.user_avatar_image_management_abr;

import screen.user_avatar_image_management_screen.UserAvatarMngViewModel;

public interface UserAvatarMngOutputBoundary {
    UserAvatarMngViewModel packageAndPresent(UserAvatarMngResponseModel responseModel);
}

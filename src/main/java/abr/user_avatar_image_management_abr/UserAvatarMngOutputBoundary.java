package abr.user_avatar_image_management_abr;

import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;

public interface UserAvatarMngOutputBoundary {
    void packageAndPresent(UserAvatarMngResponseModel responseModel);
}

package abr.user_avatar_image_management_abr;

import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;

public interface UserAvatarMngOutputBoundary {
    UserAvatarMngViewModel packageAndPresent(UserAvatarMngResponseModel responseModel);
}

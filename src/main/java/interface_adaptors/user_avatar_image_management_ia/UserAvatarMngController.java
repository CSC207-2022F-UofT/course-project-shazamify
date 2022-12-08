package interface_adaptors.user_avatar_image_management_ia;

import abr.user_avatar_image_management_abr.UserAvatarMngInputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngRequestModel;

public class UserAvatarMngController {
    UserAvatarMngInputBoundary inputBoundary;

    public UserAvatarMngController(UserAvatarMngInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public void verifyAndChangeAvatar(String directory, String userName){
        UserAvatarMngRequestModel requestModel = new UserAvatarMngRequestModel();
        requestModel.setDirectory(directory);
        requestModel.setUserName(userName);
        inputBoundary.verifyAndChangeAvatar(requestModel);
    }
}

package screen.user_avatar_image_management_screen;

import abr.user_avatar_image_management_abr.UserAvatarMngInputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngRequestModel;

public class UserAvatarMngController {
    UserAvatarMngInputBoundary inputBoundary;

    public UserAvatarMngController(UserAvatarMngInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public UserAvatarMngViewModel verifyAndChangeAvatar(String directory, String userName){
        UserAvatarMngRequestModel requestModel = new UserAvatarMngRequestModel();
        requestModel.setDirectory(directory);
        requestModel.setUserName(userName);
        return inputBoundary.verifyAndChangeAvatar(requestModel);
    }
}

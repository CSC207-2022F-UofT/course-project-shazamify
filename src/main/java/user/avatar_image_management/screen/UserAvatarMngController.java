package user.avatar_image_management.screen;

import user.avatar_image_management.abr.UserAvatarMngInputBoundary;
import user.avatar_image_management.abr.UserAvatarMngRequestModel;

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

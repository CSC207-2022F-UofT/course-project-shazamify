package interface_adaptors.user_avatar_image_management_ia;

import abr.user_avatar_image_management_abr.UserAvatarMngInputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngRequestModel;

/**
 * @author David Li
 */
public class UserAvatarMngController {
    UserAvatarMngInputBoundary inputBoundary;

    public UserAvatarMngController(UserAvatarMngInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    /**
     * Given the directory of the new avatar and the username, change the avatar of the user
     * @param directory directory of the new avatar
     * @param userName username of the user
     */
    public void verifyAndChangeAvatar(String directory, String userName){
        UserAvatarMngRequestModel requestModel = new UserAvatarMngRequestModel();
        requestModel.setDirectory(directory);
        requestModel.setUserName(userName);
        inputBoundary.verifyAndChangeAvatar(requestModel);
    }
}

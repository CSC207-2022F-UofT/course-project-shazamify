package abr.user_avatar_image_management_abr;

import java.awt.image.BufferedImage;

public class UserAvatarMngResponseModel {
    private boolean isDirectoryValid;
    private BufferedImage userAvatar;

    public void setDirectoryValid(boolean directoryValid) {
        isDirectoryValid = directoryValid;
    }

    public boolean isDirectoryValid() {
        return isDirectoryValid;
    }

    public void setUserAvatar(BufferedImage userAvatar) {
        this.userAvatar = userAvatar;
    }

    public BufferedImage getUserAvatar() {
        return userAvatar;
    }
}

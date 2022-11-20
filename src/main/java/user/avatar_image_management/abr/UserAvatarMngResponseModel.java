package user.avatar_image_management.abr;

import user.entities.User;

public class UserAvatarMngResponseModel {
    private boolean isDirectoryValid;
    private User user;

    public void setDirectoryValid(boolean directoryValid) {
        isDirectoryValid = directoryValid;
    }

    public boolean isDirectoryValid() {
        return isDirectoryValid;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

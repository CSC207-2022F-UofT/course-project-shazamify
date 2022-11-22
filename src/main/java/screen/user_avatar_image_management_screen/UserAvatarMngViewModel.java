package screen.user_avatar_image_management_screen;

import entities.user_entities.User;

public class UserAvatarMngViewModel {
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

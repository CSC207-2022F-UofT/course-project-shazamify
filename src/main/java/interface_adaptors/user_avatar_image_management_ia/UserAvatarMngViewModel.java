package interface_adaptors.user_avatar_image_management_ia;


public class UserAvatarMngViewModel {
    private boolean isDirectoryValid;

    public void setDirectoryValid(boolean directoryValid) {
        isDirectoryValid = directoryValid;
    }

    public boolean isDirectoryValid() {
        return isDirectoryValid;
    }
}

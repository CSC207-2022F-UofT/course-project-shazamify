package interface_adaptors.user_avatar_image_management_ia;


public class UserAvatarMngViewModel {
    private boolean isDirectoryValid;
    private static UserAvatarMngViewModel instance;

    private UserAvatarMngViewModel(){
    }

    public static UserAvatarMngViewModel getInstance() {
        if(instance == null) {
            instance = new UserAvatarMngViewModel();
        }
        return instance;
    }

    public void setDirectoryValid(boolean directoryValid) {
        isDirectoryValid = directoryValid;
    }

    public boolean isDirectoryValid() {
        return isDirectoryValid;
    }
}

package user.avatar_image_management.abr;

public class UserAvatarMngRequestModel {
    String directory;
    String userName;

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}

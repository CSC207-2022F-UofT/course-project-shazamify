package abr.user_login_abr;

public class UserLogResponseModel {
    boolean userNameValid;
    boolean userPasswordValid;

    public void setValidUserName(boolean validLogin) {
        this.userNameValid = validLogin;
    }

    public void setUserPasswordValid(boolean userPasswordValid) {
        this.userPasswordValid = userPasswordValid;
    }

    public boolean isValidUserName() {
        return userNameValid;
    }

    public boolean isUserPasswordValid() {
        return userPasswordValid;
    }
}

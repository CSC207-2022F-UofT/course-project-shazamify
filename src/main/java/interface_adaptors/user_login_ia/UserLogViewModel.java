package interface_adaptors.user_login_ia;

public class UserLogViewModel {
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
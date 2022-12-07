package interface_adaptors.user_login_ia;

public class UserLogViewModel {
    private boolean userNameValid;
    private boolean userPasswordValid;
    private static UserLogViewModel instance;
    public static UserLogViewModel getInstance() {
        if(instance == null) {
            instance = new UserLogViewModel();
        }
        return instance;
    }
    private UserLogViewModel(){
    }
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

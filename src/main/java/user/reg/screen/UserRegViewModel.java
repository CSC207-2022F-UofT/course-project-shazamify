package user.reg.screen;

public class UserRegViewModel {
    private boolean usernameValidity;
    private boolean passwordValidity;

    public UserRegViewModel(){
    }

    public void setUsernameValidity(boolean usernameValidity){
        this.usernameValidity = usernameValidity;
    }

    public void setPasswordValidity(boolean passwordValidity){
        this.passwordValidity = passwordValidity;
    }

    public boolean isPasswordValid() {
        return passwordValidity;
    }

    public boolean isUsernameValid() {
        return usernameValidity;
    }
}

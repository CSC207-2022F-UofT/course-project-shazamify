package user.reg.abr;

public class UserRegResponseModel {
    private boolean usernameValidity;
    private boolean passwordValidity;

    public UserRegResponseModel(){
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

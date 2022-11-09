package user.reg.abr;

public class UserRegResponseModel {
    private final boolean usernameValidity;
    private final boolean passwordValidity;

    public UserRegResponseModel(boolean usernameValidity, boolean passwordValidity){
        this.passwordValidity = passwordValidity;
        this.usernameValidity = usernameValidity;
    }

    public boolean isPasswordValid() {
        return passwordValidity;
    }

    public boolean isUsernameValid() {
        return usernameValidity;
    }
}

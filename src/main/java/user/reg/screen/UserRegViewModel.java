package user.reg.screen;

public class UserRegViewModel {
    private final boolean usernameValidity;
    private final boolean passwordValidity;

    public UserRegViewModel(boolean usernameValidity, boolean passwordValidity){
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

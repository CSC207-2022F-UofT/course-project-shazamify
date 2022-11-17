package user.reg.abr;

public class UserRegResponseModel {
    private boolean usernameValidity;
    private boolean passwordValidity;

    private String recommendPassword;

    public UserRegResponseModel(){
    }

    public void setUsernameValidity(boolean usernameValidity){
        this.usernameValidity = usernameValidity;
    }

    public void setPasswordValidity(boolean passwordValidity){
        this.passwordValidity = passwordValidity;
    }

    public void setRecommendPassword(String recommendPassword) {
        this.recommendPassword = recommendPassword;
    }

    public boolean isPasswordValid() {
        return passwordValidity;
    }

    public boolean isUsernameValid() {
        return usernameValidity;
    }

    public String getRecommendPassword() {
        return recommendPassword;
    }
}

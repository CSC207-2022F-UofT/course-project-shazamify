package abr.user_reg_abr;

public class UserRegResponseModel {
    private boolean usernameValidity;
    private boolean passwordValidity;
    private String recommendPassword;
    private boolean securityQuestionValidity;

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

    public void setSecurityQuestionValidity(boolean securityQuestionValidity){
        this.securityQuestionValidity = securityQuestionValidity;
    }

    public boolean isPasswordValid() {
        return passwordValidity;
    }

    public boolean isUsernameValid() {
        return usernameValidity;
    }

    public boolean isSecurityQuestionValidity() {
        return securityQuestionValidity;
    }

    public String getRecommendPassword() {
        return recommendPassword;
    }
}

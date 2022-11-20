package user.reg.abr;

import java.util.Map;

public class UserRegRequestModel {
    private final String password;
    private final String userName;
    private final String rePassword;
    private final Map<String, String> securityQuestionMap;

    public UserRegRequestModel(String password, String userName, String rePassword,
                               Map<String, String> securityQuestionMap){
        this.password = password;
        this.userName = userName;
        this.rePassword = rePassword;
        this.securityQuestionMap = securityQuestionMap;
    }

    public String getPassword() {
        return password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public String getUserName() {
        return userName;
    }

    public Map<String, String> getSecurityQuestions(){
        return securityQuestionMap;
    }
}

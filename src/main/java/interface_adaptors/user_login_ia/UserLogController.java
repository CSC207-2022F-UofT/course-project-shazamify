package interface_adaptors.user_login_ia;

import abr.user_login_abr.UserLogInputBoundary;
import abr.user_login_abr.UserLogRequestModel;

public class UserLogController {
    UserLogInputBoundary inputBoundary;

    public UserLogController(UserLogInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public void login(String userName, String passWord){
        UserLogRequestModel requestModel = new UserLogRequestModel(userName,passWord);

        inputBoundary.loginUser(requestModel);
    }
}

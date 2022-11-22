package interface_adaptors.user_login_screen;

import abr.user_login_abr.UserLogInputBoundary;
import abr.user_login_abr.UserLogRequestModel;

public class UserLogController {
    UserLogInputBoundary inputBoundary;

    public UserLogController(UserLogInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public UserLogViewModel login(String userName, String passWord){
        UserLogRequestModel requestModel = new UserLogRequestModel(userName,passWord);

        return inputBoundary.loginUser(requestModel);
    }
}

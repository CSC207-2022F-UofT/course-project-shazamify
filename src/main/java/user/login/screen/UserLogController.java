package user.login.screen;

import user.login.abr.UserLogInputBoundary;
import user.login.abr.UserLogRequestModel;

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

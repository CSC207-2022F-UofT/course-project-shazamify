package interface_adaptors.user_change_password_ia;

import abr.user_change_password_abr.UserCPInputBoundary;
import abr.user_change_password_abr.UserCPRequestModel;

public class UserCPController {
    UserCPInputBoundary inputBoundary;
    UserCPRequestModel requestModel;

    public UserCPController(UserCPInputBoundary userCPInputBoundary){
        this.inputBoundary = userCPInputBoundary;
        this.requestModel = new UserCPRequestModel();
    }

    public void changePassword(String userName, String passWord){
        requestModel.setPassword(passWord);
        requestModel.setUserName(userName);
        inputBoundary.changePassword(requestModel);
    }
}

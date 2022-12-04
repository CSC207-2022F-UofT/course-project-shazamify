package interface_adaptors.user_change_password_ia;

import abr.user_change_password_abr.UserChangePasswordInputBoundary;
import abr.user_change_password_abr.UserChangePasswordRequestModel;

public class UserChangePasswordController {
    UserChangePasswordInputBoundary inputBoundary;
    UserChangePasswordRequestModel requestModel;

    public UserChangePasswordController(UserChangePasswordInputBoundary userChangePasswordInputBoundary){
        this.inputBoundary = userChangePasswordInputBoundary;
        this.requestModel = new UserChangePasswordRequestModel();
    }

    public void changePassword(String userName, String passWord){
        requestModel.setPassword(passWord);
        requestModel.setUserName(userName);
        inputBoundary.changePassword(requestModel);
    }
}

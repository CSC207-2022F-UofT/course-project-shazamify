package interface_adaptors.user_change_password_ia;

import abr.user_change_password_abr.UserCPInputBoundary;
import abr.user_change_password_abr.UserCPRequestModel;

/**
 * @author David Li
 */
public class UserCPController {
    UserCPInputBoundary inputBoundary;
    UserCPRequestModel requestModel;

    public UserCPController(UserCPInputBoundary userCPInputBoundary){
        this.inputBoundary = userCPInputBoundary;
        this.requestModel = new UserCPRequestModel();
    }

    /**
     * By given userName of the user and !!NewPassword!!. The useCase will change the password to new Password
     * @param userName userName of the user
     * @param passWord new Password
     */
    public void changePassword(String userName, String passWord){
        requestModel.setPassword(passWord);
        requestModel.setUserName(userName);
        inputBoundary.changePassword(requestModel);
    }
}

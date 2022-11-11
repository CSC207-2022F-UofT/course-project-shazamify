package user.reg.abr;

import user.database.UserDataBaseGateway;
import user.database.UserFileGateway;
import user.reg.screen.UserRegViewModel;

import java.io.IOException;

public class UserRegHelper {

    public UserRegResponseModel register(UserRegRequestModel requestModel, UserRegResponseModel responseModel){
        UserDataBaseGateway gateway = new UserFileGateway();
        String password = requestModel.getPassword();
        String userName = requestModel.getUserName();
        String rePassword = requestModel.getRePassword();
        // Check if the password is equals rePassword, and package into responseModel
        responseModel.setPasswordValidity(password.equals(rePassword));
        //Check if the userName is valid for database
        responseModel.setUsernameValidity(gateway.checkAndRegisterUser(userName, password));
        return responseModel;
    }
}

package user.reg.abr;

import user.database.UserDataBaseGateway;
import user.database.UserFileGateway;
import user.reg.screen.UserRegViewModel;

import java.io.IOException;

public class UserRegHelper {


    public UserRegResponseModel register(UserRegRequestModel requestModel, UserRegResponseModel responseModel, UserDataBaseGateway dataBaseGateway){
        String password = requestModel.getPassword();
        String userName = requestModel.getUserName();
        String rePassword = requestModel.getRePassword();

        boolean passwordValidity = (checkCharacterValidity(password) & password.equals(rePassword));
        boolean userNameValidity = checkCharacterValidity(userName);

        // If all password and userName's characters are legal.
        if (userNameValidity & passwordValidity) {
            responseModel.setUsernameValidity(dataBaseGateway.checkAndRegisterUser(userName, password));
            responseModel.setPasswordValidity(true);
        } else { // If the password or userName's characters are illegal
            responseModel.setUsernameValidity(userNameValidity);
            responseModel.setPasswordValidity(passwordValidity);
        }
        return responseModel;
    }

    private boolean checkCharacterValidity(String string) {
        //Generate a String with all valid Characters
        StringBuilder valid = new StringBuilder();
        for (int i = 48; i < 123; i++){
            valid.append((char) i);
        }
        String validCharacter = valid.toString();

        for (char c: string.toCharArray()){
            // Find if there exist invalid character in Password String
            if (validCharacter.indexOf(c) == -1){
                return false;
            }
        }
        return true;

    }
}

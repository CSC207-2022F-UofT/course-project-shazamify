package abr.user_reg_abr;

import entities.user_entities.UserSecurityQuestionPackage;

import java.util.Map;

public class UserRegHelper {


    public UserRegResponseModel register(UserRegRequestModel requestModel, UserRegResponseModel responseModel, UserRegisterDataBaseGateway dataBaseGateway){
        // Get all required information from request model
        String password = requestModel.getPassword();
        String userName = requestModel.getUserName();
        String rePassword = requestModel.getRePassword();
        Map<String, String> securityQuestionMap = requestModel.getSecurityQuestions();

        // Check the validity of password and userName
        boolean securityQuestionValidity = checkSecurityQuestionValidity(securityQuestionMap);
        boolean passwordValidity = (checkCharacterValidity(password) && password.equals(rePassword));
        boolean userNameValidity = checkCharacterValidity(userName);

        // If all password, userName and security questions are legal.
        if (userNameValidity & passwordValidity & securityQuestionValidity) {
            UserSecurityQuestionPackage securityQuestionPackage = packageSecurityQuestions(securityQuestionMap);
            responseModel.setSecurityQuestionValidity(true);
            responseModel.setUsernameValidity(dataBaseGateway.checkAndRegisterUser(userName, password, securityQuestionPackage));
            responseModel.setPasswordValidity(true);
        } else { // If the password or userName's characters are illegal
            responseModel.setSecurityQuestionValidity(securityQuestionValidity);
            responseModel.setUsernameValidity(userNameValidity);
            responseModel.setPasswordValidity(passwordValidity);
        }
        return responseModel;
    }

    private UserSecurityQuestionPackage packageSecurityQuestions(Map<String, String> securityQuestionMap) {
        return null;
    }

    private boolean checkSecurityQuestionValidity(Map<String, String> securityQuestionMap) {
        // Condition if security question have 0 length
        if (securityQuestionMap.size() == 0){
            return false;
        // return false if security question answer contain empty string.
        } else return !securityQuestionMap.containsValue("");
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

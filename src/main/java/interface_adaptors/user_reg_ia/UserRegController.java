package interface_adaptors.user_reg_ia;

import abr.user_reg_abr.UserRegInputBoundary;
import abr.user_reg_abr.UserRegRequestModel;

import java.util.Map;

public class UserRegController {
    UserRegInputBoundary inputBoundary;

    public UserRegController(UserRegInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    /**
     *
     * @param userName the username of the registered user
     * @param password the password of the registered user
     * @param rePassword the confirmation password of registered user
     * @param securityQuestions the questions for reset password
     * @return A ViewModel contain whether registration is successful
     */
    public UserRegViewModel register(String userName, String password, String rePassword,
                                     Map<String, String> securityQuestions){
        UserRegRequestModel requestModel = new UserRegRequestModel(password, userName, rePassword, securityQuestions);

        return inputBoundary.register(requestModel);
    }

    public UserRegViewModel giveRecommendPassword(){
        return inputBoundary.giveRecommendPassword();
    }
}

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
     */
    public void register(String userName, String password, String rePassword,
                                     Map<String, String> securityQuestions){
        UserRegRequestModel requestModel = new UserRegRequestModel(password, userName, rePassword, securityQuestions);
        inputBoundary.register(requestModel);
    }

    public void giveRecommendPassword(){
        inputBoundary.giveRecommendPassword();
    }
}

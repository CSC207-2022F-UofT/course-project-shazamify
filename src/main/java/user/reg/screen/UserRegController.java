package user.reg.screen;

import user.reg.abr.UserRegInputBoundary;
import user.reg.abr.UserRegRequestModel;

import java.io.IOException;

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
     * @return A ViewModel contain whether registration is successful
     */
    public UserRegViewModel register(String userName, String password, String rePassword){
        UserRegRequestModel requestModel = new UserRegRequestModel(password, userName, rePassword);

        return inputBoundary.register(requestModel);
    }

    public void giveRecommendPassword(){
        //TODO: give recommend password
    }
}

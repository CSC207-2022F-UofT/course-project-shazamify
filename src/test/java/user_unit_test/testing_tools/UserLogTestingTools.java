package user_unit_test.testing_tools;

import abr.user_login_abr.UserLogInputBoundary;
import abr.user_login_abr.UserLogUseCase;
import abr.user_login_abr.UserLoginDataBaseGateway;
import ds.user_login_ds.UserLoginFileGateway;
import interface_adaptors.user_login_ia.UserLogController;
import interface_adaptors.user_login_ia.UserLogPresenter;
import interface_adaptors.user_login_ia.UserLogViewModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;

/**
 * @author David Li
 */
public class UserLogTestingTools {

    /**
     * Login the user, and mutate viewModels
     */
    public static void LoginUser(String userName, String passWord, UserLogViewModel userLogViewModel, UserStatusViewModel statusViewModel){
        UserLogController userLogController = initializeTestingPlatform(userLogViewModel, statusViewModel);
        userLogController.login(userName, passWord);
    }

    private static UserLogController initializeTestingPlatform(UserLogViewModel userLogViewModel, UserStatusViewModel statusViewModel) {
        // Initialize the User Presenter
        UserLogPresenter userLogPresenter = new UserLogPresenter(userLogViewModel, statusViewModel);
        // Initialize the User Database Gateway
        UserLoginDataBaseGateway userLoginDataBaseGateway = new UserLoginFileGateway();
        // Initialize the User ABR
        UserLogInputBoundary userLogInputBoundary = new UserLogUseCase(userLogPresenter, userLoginDataBaseGateway);
        // Initialize the User Controller
        return new UserLogController(userLogInputBoundary);
    }
}

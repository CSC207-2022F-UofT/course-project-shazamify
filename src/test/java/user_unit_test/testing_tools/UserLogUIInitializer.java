package user_unit_test.testing_tools;


import abr.user_login_abr.UserLogInputBoundary;
import abr.user_login_abr.UserLogUseCase;
import abr.user_login_abr.UserLoginDataBaseGateway;
import ds.user_login_ds.UserLoginFileGateway;
import framework.user_screen.UserLogUI;
import interface_adaptors.user_login_ia.UserLogController;
import interface_adaptors.user_login_ia.UserLogPresenter;
import interface_adaptors.user_login_ia.UserLogViewModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;

/**
 @author David Li
 */
public class UserLogUIInitializer {


    public static void initializeUI(UserLogViewModel logViewModel, UserStatusViewModel statusViewModel){
        // Initialize the User Presenter
        UserLogPresenter userLogPresenter = new UserLogPresenter(logViewModel, statusViewModel);
        // Initialize the User Database Gateway
        UserLoginDataBaseGateway userLoginDataBaseGateway = new UserLoginFileGateway();
        // Initialize the User ABR
        UserLogInputBoundary userLogInputBoundary = new UserLogUseCase(userLogPresenter, userLoginDataBaseGateway);
        // Initialize the User Controller
        UserLogController userLogController = new UserLogController(userLogInputBoundary);
        // Initialize the User UI.
        new UserLogUI(userLogController,logViewModel);
        }

    public static void main(String[] args) {
        UserLogViewModel logViewModel = new UserLogViewModel();
        UserStatusViewModel statusViewModel = new UserStatusViewModel();
        UserLogUIInitializer.initializeUI(logViewModel, statusViewModel);
    }
}

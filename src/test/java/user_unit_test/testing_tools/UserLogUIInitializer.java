package user_unit_test.testing_tools;


import abr.user_change_password_abr.UserChangePasswordDatabaseGateway;
import abr.user_change_password_abr.UserChangePasswordInputBoundary;
import abr.user_change_password_abr.UserChangePasswordOutputBoundary;
import abr.user_change_password_abr.UserChangePasswordUseCase;
import abr.user_login_abr.UserLogInputBoundary;
import abr.user_login_abr.UserLogUseCase;
import abr.user_login_abr.UserLoginDataBaseGateway;
import ds.user_change_password_ds.UserChangePasswordFileGateway;
import ds.user_login_ds.UserLoginFileGateway;
import framework.user_screen.UserLogUI;
import interface_adaptors.user_change_password_ia.UserChangePasswordController;
import interface_adaptors.user_change_password_ia.UserChangePasswordPresenter;
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

        UserChangePasswordOutputBoundary userChangePasswordOutputBoundary = new UserChangePasswordPresenter(statusViewModel);
        UserChangePasswordDatabaseGateway userChangePasswordDatabaseGateway = new UserChangePasswordFileGateway();
        UserChangePasswordInputBoundary userChangePasswordInputBoundary =
                new UserChangePasswordUseCase(userChangePasswordOutputBoundary, userChangePasswordDatabaseGateway);
        UserChangePasswordController userChangePasswordController =  new UserChangePasswordController(userChangePasswordInputBoundary);

        new UserLogUI(userLogController,logViewModel, statusViewModel, userChangePasswordController);
        }

    public static void main(String[] args) {
        UserLogViewModel logViewModel = new UserLogViewModel();
        UserStatusViewModel statusViewModel = new UserStatusViewModel();
        UserLogUIInitializer.initializeUI(logViewModel, statusViewModel);
    }
}

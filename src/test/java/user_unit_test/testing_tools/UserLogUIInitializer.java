package user_unit_test.testing_tools;


import abr.user_change_password_abr.UserCPDatabaseGateway;
import abr.user_change_password_abr.UserCPInputBoundary;
import abr.user_change_password_abr.UserCPOutputBoundary;
import abr.user_change_password_abr.UserCPUseCase;
import abr.user_login_abr.UserLogInputBoundary;
import abr.user_login_abr.UserLogUseCase;
import abr.user_login_abr.UserLoginDataBaseGateway;
import ds.user_change_password_ds.UserCPFileGateway;
import ds.user_login_ds.UserLoginFileGateway;
import framework.user_screen.UserLogUI;
import interface_adaptors.user_change_password_ia.UserCPController;
import interface_adaptors.user_change_password_ia.UserCPPresenter;
import interface_adaptors.user_login_ia.UserLogController;
import interface_adaptors.user_login_ia.UserLogPresenter;

/**
 @author David Li
 */
public class UserLogUIInitializer {

    public static void initializeUI(){
        // Initialize the User Presenter
        UserLogPresenter userLogPresenter = new UserLogPresenter();
        // Initialize the User Database Gateway
        UserLoginDataBaseGateway userLoginDataBaseGateway = new UserLoginFileGateway();
        // Initialize the User ABR
        UserLogInputBoundary userLogInputBoundary = new UserLogUseCase(userLogPresenter, userLoginDataBaseGateway);
        // Initialize the User Controller
        UserLogController userLogController = new UserLogController(userLogInputBoundary);
        // Initialize the User UI.

        UserCPOutputBoundary userCPOutputBoundary = new UserCPPresenter();
        UserCPDatabaseGateway userCPDatabaseGateway = new UserCPFileGateway();
        UserCPInputBoundary userCPInputBoundary =
                new UserCPUseCase(userCPOutputBoundary, userCPDatabaseGateway);
        UserCPController userCPController =  new UserCPController(userCPInputBoundary);

        new UserLogUI(userLogController, userCPController);
        }

    public static void main(String[] args) {
        UserLogUIInitializer.initializeUI();
    }
}

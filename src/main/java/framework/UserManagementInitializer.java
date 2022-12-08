package framework;

import abr.user_change_password_abr.UserCPDatabaseGateway;
import abr.user_change_password_abr.UserCPInputBoundary;
import abr.user_change_password_abr.UserCPOutputBoundary;
import abr.user_change_password_abr.UserCPUseCase;
import abr.user_login_abr.UserLogInputBoundary;
import abr.user_login_abr.UserLogUseCase;
import abr.user_login_abr.UserLoginDataBaseGateway;
import abr.user_reg_abr.UserRegInputBoundary;
import abr.user_reg_abr.UserRegUseCase;
import abr.user_reg_abr.UserRegisterDataBaseGateway;
import ds.user_change_password_ds.UserCPFileGateway;
import ds.user_login_ds.UserLoginFileGateway;
import ds.user_reg_ds.UserRegisterFileGateway;
import interface_adaptors.user_change_password_ia.UserCPController;
import interface_adaptors.user_change_password_ia.UserCPPresenter;
import interface_adaptors.user_login_ia.UserLogController;
import interface_adaptors.user_login_ia.UserLogPresenter;
import interface_adaptors.user_reg_ia.UserRegController;
import interface_adaptors.user_reg_ia.UserRegPresenter;

public class UserManagementInitializer {

    public static UserLogController getLogController() {
        // Initialize the User Presenter
        UserLogPresenter userLogPresenter = new UserLogPresenter();
        // Initialize the User Database Gateway
        UserLoginDataBaseGateway userLoginDataBaseGateway = new UserLoginFileGateway();
        // Initialize the User ABR
        UserLogInputBoundary userLogInputBoundary = new UserLogUseCase(userLogPresenter, userLoginDataBaseGateway);
        // Initialize the User Controller
        return new UserLogController(userLogInputBoundary);
    }

    public static UserRegController getRegController(){
        // Initialize the User Presenter
        UserRegPresenter userRegPresenter = new UserRegPresenter();
        // Initialize the User Database Gateway
        UserRegisterDataBaseGateway userRegisterDataBaseGateway = new UserRegisterFileGateway();
        // Initialize the User ABR
        UserRegInputBoundary userRegUseCase = new UserRegUseCase(userRegPresenter, userRegisterDataBaseGateway);
        // Initialize the User Controller

        return new UserRegController(userRegUseCase);
    }

    public static UserCPController getChangePasswordController(){
        //InitializePresenter
        UserCPOutputBoundary userCPOutputBoundary = new UserCPPresenter();
        // Initialize Database Gateway
        UserCPDatabaseGateway userCPDatabaseGateway = new UserCPFileGateway();
        //InitializeUseCase
        UserCPInputBoundary userCPUseCase = new UserCPUseCase(userCPOutputBoundary, userCPDatabaseGateway);
        //Initialize Controller

        return new UserCPController(userCPUseCase);
    }
}

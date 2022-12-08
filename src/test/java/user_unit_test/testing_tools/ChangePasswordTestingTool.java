package user_unit_test.testing_tools;

import abr.user_change_password_abr.UserCPDatabaseGateway;
import abr.user_change_password_abr.UserCPInputBoundary;
import abr.user_change_password_abr.UserCPOutputBoundary;
import abr.user_change_password_abr.UserCPUseCase;
import ds.user_change_password_ds.UserCPFileGateway;
import interface_adaptors.user_avatar_image_management_ia.UserChangeMngPresenter;
import interface_adaptors.user_change_password_ia.UserCPController;
import interface_adaptors.user_change_password_ia.UserCPPresenter;

public class ChangePasswordTestingTool {

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

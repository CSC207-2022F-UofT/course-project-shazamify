package user_unit_test.UI_showcase;

import abr.user_avatar_image_management_abr.UserAvatarDatabaseGateway;
import abr.user_avatar_image_management_abr.UserAvatarMngInputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngOutputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngUseCase;
import abr.user_change_password_abr.UserCPDatabaseGateway;
import abr.user_change_password_abr.UserCPInputBoundary;
import abr.user_change_password_abr.UserCPOutputBoundary;
import abr.user_change_password_abr.UserCPUseCase;
import ds.user_avatar_image_management_ds.UserAvatarFileGateway;
import ds.user_change_password_ds.UserCPFileGateway;
import framework.user_screen.UserHomePageUI;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngController;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import interface_adaptors.user_avatar_image_management_ia.UserChangeMngPresenter;
import interface_adaptors.user_change_password_ia.UserCPController;
import interface_adaptors.user_change_password_ia.UserCPPresenter;
import interface_adaptors.user_login_ia.UserStatusViewModel;

/**
 * @author David Li
 * Initialize a UserHomePageUI
 */
public class UserHomePageUIInitializer {
    /**
     * Initialize a UserHomePageUI by given UserAvatarMngViewModel and UserStatusViewModel.
     * !! Do not try to pass in an empty UserStatusViewModel, this will cause an error. !!
     * !! Please Register or Login First !!
     */
    public static UserHomePageUI initializeUI(){
        // UserAvatarPart
        UserAvatarMngOutputBoundary userAvatarMngOutputBoundary = new UserChangeMngPresenter();
        UserAvatarDatabaseGateway userAvatarDatabaseGateway = new UserAvatarFileGateway();
        UserAvatarMngInputBoundary userAvatarMngInputBoundary = new UserAvatarMngUseCase(userAvatarDatabaseGateway, userAvatarMngOutputBoundary);
        UserAvatarMngController userAvatarMngController= new UserAvatarMngController(userAvatarMngInputBoundary);
        // User Change PassWord part
        UserCPOutputBoundary userCPOutputBoundary = new UserCPPresenter();
        UserCPDatabaseGateway userCPDatabaseGateway = new UserCPFileGateway();
        UserCPInputBoundary userCPInputBoundary =
                new UserCPUseCase(userCPOutputBoundary, userCPDatabaseGateway);
        UserCPController userCPController =  new UserCPController(userCPInputBoundary);

        // Initialize the UI
        return new UserHomePageUI(userAvatarMngController, userCPController);
    }
}

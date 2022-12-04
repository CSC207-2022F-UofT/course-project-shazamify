package user_unit_test.testing_tools;

import abr.user_avatar_image_management_abr.UserAvatarDatabaseGateway;
import abr.user_avatar_image_management_abr.UserAvatarMngInputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngOutputBoundary;
import abr.user_avatar_image_management_abr.UserAvatarMngUseCase;
import abr.user_change_password_abr.UserChangePasswordDatabaseGateway;
import abr.user_change_password_abr.UserChangePasswordInputBoundary;
import abr.user_change_password_abr.UserChangePasswordOutputBoundary;
import abr.user_change_password_abr.UserChangePasswordUseCase;
import ds.user_avatar_image_management_ds.UserAvatarFileGateway;
import ds.user_change_password_ds.UserChangePasswordFileGateway;
import framework.user_screen.UserHomePageUI;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngController;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import interface_adaptors.user_avatar_image_management_ia.UserChangeMngPresenter;
import interface_adaptors.user_change_password_ia.UserChangePasswordController;
import interface_adaptors.user_change_password_ia.UserChangePasswordPresenter;
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
     * @param userAvatarMngViewModel The ViewModel for User avatar
     * @param userStatusViewModel The ViewModel for User Status
     */
    public static UserHomePageUI initializeUI(UserAvatarMngViewModel userAvatarMngViewModel, UserStatusViewModel userStatusViewModel){
        // UserAvatarPart
        UserAvatarMngOutputBoundary userAvatarMngOutputBoundary = new UserChangeMngPresenter(userAvatarMngViewModel, userStatusViewModel);
        UserAvatarDatabaseGateway userAvatarDatabaseGateway = new UserAvatarFileGateway();
        UserAvatarMngInputBoundary userAvatarMngInputBoundary = new UserAvatarMngUseCase(userAvatarDatabaseGateway, userAvatarMngOutputBoundary);
        UserAvatarMngController userAvatarMngController= new UserAvatarMngController(userAvatarMngInputBoundary);
        // User Change PassWord part
        UserChangePasswordOutputBoundary userChangePasswordOutputBoundary = new UserChangePasswordPresenter(userStatusViewModel);
        UserChangePasswordDatabaseGateway userChangePasswordDatabaseGateway = new UserChangePasswordFileGateway();
        UserChangePasswordInputBoundary userChangePasswordInputBoundary =
                new UserChangePasswordUseCase(userChangePasswordOutputBoundary, userChangePasswordDatabaseGateway);
        UserChangePasswordController userChangePasswordController =  new UserChangePasswordController(userChangePasswordInputBoundary);

        // Initialize the UI
        return new UserHomePageUI(userAvatarMngController, userChangePasswordController, userStatusViewModel, userAvatarMngViewModel);
    }
}

package user_unit_test.testing_tools;

import framework.user_screen.UserHomePageUI;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import interface_adaptors.user_login_ia.UserLogViewModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import interface_adaptors.user_reg_ia.UserRegViewModel;

public class UserUIInitializer {
    public static void main(String[] args) {
        UserDataBaseEraser.eraseUserDataBase();
        UserAvatarMngViewModel userAvatarMngViewModel = new UserAvatarMngViewModel();
        UserStatusViewModel userStatusViewModel = UserStatusViewModel.getInstance();

        LoginAndRegister();

        UserLogUIInitializer.initializeUI();
        UserRegUIInitializer.initializeUI();
        UserHomePageUI userHomePageUI = UserHomePageUIInitializer.initializeUI(userAvatarMngViewModel);
        userStatusViewModel.addUserStatusObserver(userHomePageUI);
    }

    private static void LoginAndRegister() {
        UserRegTestingTools.registerUser("1234567890","1234567890","1234567890");
        UserLogTestingTools.LoginUser("1234567890","1234567890");
    }
}

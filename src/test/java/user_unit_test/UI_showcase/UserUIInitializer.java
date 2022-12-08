package user_unit_test.UI_showcase;

import framework.user_screen.UserHomePageUI;
import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngViewModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import user_unit_test.testing_tools.UserDataBaseEraser;
import user_unit_test.testing_tools.UserLogTestingTools;
import user_unit_test.testing_tools.UserRegTestingTools;

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

package user_unit_test.status;
import interface_adaptors.user_change_password_ia.UserCPController;
import interface_adaptors.user_login_ia.UserLogViewModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import org.junit.Test;
import user_unit_test.testing_tools.ChangePasswordTestingTool;
import user_unit_test.testing_tools.UserDataBaseEraser;
import user_unit_test.testing_tools.UserLogTestingTools;
import user_unit_test.testing_tools.UserRegTestingTools;

import java.awt.image.BufferedImage;

public class UserStatusViewModelTest {
    @Test
    public void statusViewModelTesting(){
        UserDataBaseEraser.eraseUserDataBase();

        UserStatusViewModel userStatusViewModel = UserStatusViewModel.getInstance();

        // Test the default user
        assert userStatusViewModel.getUserName().equals("Guest");
        assert userStatusViewModel.getPassWord() == null;
        assert userStatusViewModel.getUserAvatar() != null;

        // Test the loggedIn user
        UserRegTestingTools.registerUser("testName","testPassword", "testPassword");
        UserLogTestingTools.LoginUser("testName", "testPassword");

        assert userStatusViewModel.getUserName().equals("testName");
        assert userStatusViewModel.getUserName().equals("testPassword");
        BufferedImage bufferedImage = userStatusViewModel.getUserAvatar();

        // Test the Changing Image

    }
}

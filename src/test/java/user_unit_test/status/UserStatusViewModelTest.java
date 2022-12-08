package user_unit_test.status;

import interface_adaptors.user_login_ia.UserStatusViewModel;
import org.junit.Test;
import user_unit_test.testing_tools.UserDataBaseEraser;
import user_unit_test.testing_tools.UserLogTestingTools;
import user_unit_test.testing_tools.UserRegTestingTools;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class UserStatusViewModelTest {
    @Test
    public void statusViewModelTesting() {
        UserDataBaseEraser.eraseUserDataBase();

        UserStatusViewModel userStatusViewModel = UserStatusViewModel.getInstance();
        userStatusViewModel.initializeDefaultUser();
        // Test the default user
        assertEquals("Guest", userStatusViewModel.getUserName());
        assertNull(userStatusViewModel.getPassWord());
        assertNotNull(userStatusViewModel.getUserAvatar());

        // Test the loggedIn user
        UserRegTestingTools.registerUser("testName", "testPassword", "testPassword");
        UserLogTestingTools.LoginUser("testName", "testPassword");

        assertEquals("testName", userStatusViewModel.getUserName());
        assertEquals("testPassword", userStatusViewModel.getPassWord());
        BufferedImage bufferedImage = userStatusViewModel.getUserAvatar();

        // Test the Changing Image

    }
}
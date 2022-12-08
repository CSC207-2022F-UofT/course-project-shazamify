package user_unit_test.change_password_testing;

import interface_adaptors.user_change_password_ia.UserCPController;
import interface_adaptors.user_login_ia.UserLogViewModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import org.junit.Test;
import user_unit_test.testing_tools.ChangePasswordTestingTool;
import user_unit_test.testing_tools.UserDataBaseEraser;
import user_unit_test.testing_tools.UserLogTestingTools;
import user_unit_test.testing_tools.UserRegTestingTools;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChangePasswordUnitTest {
    @Test
    public void changePasswordTesting() {
        UserStatusViewModel userStatusViewModel = UserStatusViewModel.getInstance();
        UserDataBaseEraser.eraseUserDataBase();

        // Register and login the test user
        UserRegTestingTools.registerUser("testName","testPassword", "testPassword");
        UserLogTestingTools.LoginUser("testName", "testPassword");

        // Test the changing Password
        UserCPController userCPController = ChangePasswordTestingTool.getChangePasswordController();
        userCPController.changePassword("testName", "newTestPassword");

        // Test if we can login with the new password
        assertEquals("newTestPassword", userStatusViewModel.getPassWord());
        UserLogTestingTools.LoginUser("testName","newTestPassword");

        assertTrue(UserLogViewModel.getInstance().isValidUserName());
        assertTrue(UserLogViewModel.getInstance().isUserPasswordValid());

    }
}

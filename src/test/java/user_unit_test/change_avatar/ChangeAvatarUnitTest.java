package user_unit_test.change_avatar;

import interface_adaptors.user_avatar_image_management_ia.UserAvatarMngController;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import org.junit.Test;
import user_unit_test.testing_tools.ChangeAvatarTestingTools;
import user_unit_test.testing_tools.UserDataBaseEraser;
import user_unit_test.testing_tools.UserLogTestingTools;
import user_unit_test.testing_tools.UserRegTestingTools;

import java.awt.image.BufferedImage;

public class ChangeAvatarUnitTest {
    @Test
    public void changeAvatarTesting() {
        UserStatusViewModel userStatusViewModel = UserStatusViewModel.getInstance();
        UserDataBaseEraser.eraseUserDataBase();

        // Register and login the test user
        UserRegTestingTools.registerUser("testName","testPassword", "testPassword");
        UserLogTestingTools.LoginUser("testName", "testPassword");

        // Get the controller of the Avatar management
        UserAvatarMngController userAvatarMngController = ChangeAvatarTestingTools.getChangeAvatarController();

        // Get the old avatar of the user
        int oldAvatarHashCode = userStatusViewModel.getUserAvatar().hashCode();

        // change the avatar
        userAvatarMngController.verifyAndChangeAvatar("test_avatar.jpg", "testName");

        int newAvatarHashCode = userStatusViewModel.getUserAvatar().hashCode();

        assert newAvatarHashCode != oldAvatarHashCode;
    }
}

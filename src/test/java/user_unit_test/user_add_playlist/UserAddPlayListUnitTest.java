package user_unit_test.user_add_playlist;

import entities.playlist_entities.Playlist;
import framework.UserManagementInitializer;
import interface_adaptors.user_login_ia.UserStatusViewModel;
import interface_adaptors.user_playlist_ia.UserPlayListController;
import org.junit.Test;
import user_unit_test.testing_tools.UserLogTestingTools;
import user_unit_test.testing_tools.UserRegTestingTools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserAddPlayListUnitTest {
    @Test
    public void userAddPlayListUnitTest(){
        UserPlayListController userPlayListController = UserManagementInitializer.getUserPlaylistController();

        //Register and login the User
        UserRegTestingTools.registerUser("testUser","testPassword","testPassword");
        UserLogTestingTools.LoginUser("testUser","testPassword");

        //Add Playlist to User;
        userPlayListController.addPlayListInUser("testUser", "testPlayList");

        //Check if the playlist been update in viewModel
        assertEquals(1, UserStatusViewModel.getInstance().getPlayListIds().size());

        //Check if the playlist been updated in UserDatabase
        UserStatusViewModel.getInstance().initializeDefaultUser();
        UserLogTestingTools.LoginUser("testUser","testPassword");
        assertEquals(1,UserStatusViewModel.getInstance().getPlayListIds().size());

        //Delete playlist in User;
        userPlayListController.deletePlaylistInUser("testUser", "testPlayList");

        //Check if the playlist been update in viewModel
        assertEquals(0, UserStatusViewModel.getInstance().getPlayListIds().size());
    }
}

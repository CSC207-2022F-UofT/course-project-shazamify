package user_interact_abr_test;


import org.junit.Test;
import ds.user_database.*;
import entities.user_entities.*;
import ds.user_interact_ds.FriendManagerFileDsGateway;
import java.util.*;


public class FriendManagerFileDsGatewayTest {

    @Test
    public void saveAndGetFriendListTest() {
        FriendManagerFileDsGateway.clearDatabase();

        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        FriendManagerFileDsGateway dsGateway = new FriendManagerFileDsGateway();

        User newUser1 = new CommonUser("Star", "ababab");
        User newUser2 = new CommonUser("Jae", "ababab");

        userMap.put("Star", newUser1);
        userMap.put("Jae", newUser2);

        UserFileWriter.writeUserMap(userMap,"UserDatabase.ser");

        HashMap<String, String> starFriendList = new HashMap<>();
        starFriendList.put("Jae", "friend");

        HashMap<String, String> jaeFriendList = new HashMap<>();
        jaeFriendList.put("Star", "friend");

        dsGateway.save("Star", "Jae", starFriendList, jaeFriendList);

        assert Objects.equals(dsGateway.getFriendList("Star").get("Jae"), "friend");
        assert Objects.equals(dsGateway.getFriendList("Jae").get("Star"), "friend");
    }

}
package interface_adaptors.user_interact_screen.friend_manager_screen;

import java.util.HashMap;

public interface FriendListObserver { // implemented by all controllers
    void updateTempFriendList(HashMap<String, String> tempFriendList);
}

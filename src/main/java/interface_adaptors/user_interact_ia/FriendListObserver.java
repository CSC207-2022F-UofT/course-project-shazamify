package interface_adaptors.user_interact_ia;

import java.util.HashMap;

public interface FriendListObserver { // implemented by all controllers
    void updateTempFriendList(HashMap<String, String> tempFriendList);
}

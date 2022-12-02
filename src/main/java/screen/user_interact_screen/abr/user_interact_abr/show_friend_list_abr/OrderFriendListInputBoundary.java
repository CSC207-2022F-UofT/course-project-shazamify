package screen.user_interact_screen.abr.user_interact_abr.show_friend_list_abr;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderFriendListInputBoundary {

    ArrayList<String> returnOrderedUserFriendList(HashMap<String, String> currentFriendList);
}

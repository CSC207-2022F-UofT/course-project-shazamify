package abr.user_interact_abr.manage_friend_request_abr;

import java.util.HashMap;

public class FriendManagerRequestModel {

    private final String userID;
    private final String friendID;
    private final HashMap<String, String> userFriendList;

    /**
     * obj containing input data for friend manager use cases to function
     */
    public FriendManagerRequestModel(String userID, String friendID, HashMap<String, String> userFriendList) {
        this.userID = userID;
        this.friendID = friendID;
        this.userFriendList = userFriendList;
    }

    public String getUserID() {
        return userID;
    }

    public String getFriendID() {
        return friendID;
    }

    public HashMap<String, String> getUserFriendList(){ return this.userFriendList; }


}

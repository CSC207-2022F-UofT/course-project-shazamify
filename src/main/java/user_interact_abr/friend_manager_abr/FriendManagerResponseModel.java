package user_interact_abr.friend_manager_abr;

import java.util.HashMap;

public class FriendManagerResponseModel {
    private final String userID;
    private final String friendID;
    private final HashMap<String, String> userFriendList;
    private final HashMap<String, String> friendFriendList;
    public FriendManagerResponseModel(String userID, String friendID, HashMap<String, String> userFriendList, HashMap<String, String> friendFriendList) {

        this.userID = userID;
        this.friendID = friendID;
        this.friendFriendList = friendFriendList;
        this.userFriendList = userFriendList;
    }

    public String getUserID() {return userID;}

    public String getFriendID() {return friendID;}

    public HashMap<String, String> getUserFriendList(){ return this.userFriendList; }

    public HashMap<String, String> getFriendFriendList(){ return this.friendFriendList; }
}

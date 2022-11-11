package user_interact_abr.friend_manager_abr;

import java.util.HashMap;

public class FriendManagerDsRequestModel{

    private final String userID;

    private final String friendID;

    private HashMap<String, String> userFriendList;

    private HashMap<String, String> friendFriendList;


    public FriendManagerDsRequestModel(String userID, String friendID, HashMap<String, String> userFriendList, HashMap<String, String> friendFriendList) {
        this.userID = userID;
        this.friendID = friendID;
        this.userFriendList = userFriendList;
        this.friendFriendList = friendFriendList;
    }

    public String getUserID() {
        return userID;
    }

    public String getFriendID(){ return friendID; }

    public HashMap<String, String> getUserFriendList() {
        return userFriendList;
    }

    public void setUserFriendList(HashMap<String, String> userFriendList) {
        this.userFriendList = userFriendList;
    }

    public HashMap<String, String> getFriendFriendList() {
        return friendFriendList;
    }

    public void setFriendFriendList(HashMap<String, String> friendFriendList) {
        this.friendFriendList = friendFriendList;
    }
}

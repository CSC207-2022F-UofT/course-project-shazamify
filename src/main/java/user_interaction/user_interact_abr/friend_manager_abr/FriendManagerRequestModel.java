package user_interaction.user_interact_abr.friend_manager_abr;

import java.util.HashMap;

public class FriendManagerRequestModel {

    private String userID;
    private String friendID;
    private final HashMap<String, String> userFriendList;
    private final HashMap<String, String> friendFriendList;

    public FriendManagerRequestModel(String userID, String friendID, HashMap<String, String> userFriendList, HashMap<String, String> friendFriendList) {
        this.userID = userID;
        this.friendID = friendID;
        this.friendFriendList = friendFriendList;
        this.userFriendList = userFriendList;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFriendID() {
        return friendID;
    }

    public void setFriendID(String friendID) {
        this.friendID = friendID;
    }

    public HashMap<String, String> getUserFriendList(){ return this.userFriendList; }

    public HashMap<String, String> getFriendFriendList(){ return this.friendFriendList; }

}

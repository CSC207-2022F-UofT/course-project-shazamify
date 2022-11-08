package UserInteractABR.FriendManagerABR;

import java.util.HashMap;

public class FriendManagerDsRequestModel{

    private final String userID;

    private final String friendID;

    private HashMap<String, String> friendList;


    public FriendManagerDsRequestModel(String userID, String friendID, HashMap<String, String> friendList) {
        this.userID = userID;
        this.friendID = friendID;
        this.friendList = friendList;
    }

    public String getUserID() {
        return userID;
    }

    public HashMap<String, String> getFriendList() {
        return friendList;
    }

    public String getFriendID(){ return friendID; }

    public void setFriendList(HashMap<String, String> friendList) {
        this.friendList = friendList;
    }
}

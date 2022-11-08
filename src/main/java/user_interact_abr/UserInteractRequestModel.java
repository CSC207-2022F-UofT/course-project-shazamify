package user_interact_abr;

import java.util.HashMap;

public class UserInteractRequestModel {

    private String userID;
    private String friendID;

    private HashMap<String, String> friendList;

    public UserInteractRequestModel(String userID, String friendID) {
        this.userID = userID;
        this.friendID = friendID;
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

}

package user_interact_abr.friend_manager_abr;

import java.util.HashMap;

public class FriendManagerDsRequestModel{

    private final int userID;

    private final int friendID;

    private HashMap<Integer, String> userFriendList;

    private HashMap<Integer, String> friendFriendList;


    public FriendManagerDsRequestModel(int userID, int friendID, HashMap<Integer, String> userFriendList, HashMap<Integer, String> friendFriendList) {
        this.userID = userID;
        this.friendID = friendID;
        this.userFriendList = userFriendList;
        this.friendFriendList = friendFriendList;
    }

    public int getUserID() {
        return userID;
    }

    public int getFriendID(){ return friendID; }

    public HashMap<Integer, String> getUserFriendList() {
        return userFriendList;
    }

    public void setUserFriendList(HashMap<Integer, String> userFriendList) {
        this.userFriendList = userFriendList;
    }

    public HashMap<Integer, String> getFriendFriendList() {
        return friendFriendList;
    }

    public void setFriendFriendList(HashMap<Integer, String> friendFriendList) {
        this.friendFriendList = friendFriendList;
    }
}

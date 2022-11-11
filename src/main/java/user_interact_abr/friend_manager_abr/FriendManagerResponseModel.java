package user_interact_abr.friend_manager_abr;

public class FriendManagerResponseModel {
    private final String userID;

    private final String friendID;

    public FriendManagerResponseModel(String userID, String friendID) {

        this.userID = userID;
        this.friendID = friendID;
    }

    public String getUserID() {
        return userID;
    }

    public String getFriendID() {
        return friendID;
    }
}

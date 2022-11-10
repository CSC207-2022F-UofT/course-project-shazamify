package user_interact_abr.friend_manager_abr;

public class FriendManagerResponseModel {

    private final int userID;

    private final int friendID;

    public FriendManagerResponseModel(int userID, int friendID) {


        this.userID = userID;
        this.friendID = friendID;
    }


    public int getUserID() {
        return userID;
    }

    public int getFriendID() {

        return friendID;
    }
}

package abr.user_interact_abr.manage_friend_request_abr.sending_or_accepting_attempt_abr;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerRequestModel;

import java.util.HashMap;
import java.util.Objects;

//refactoring long method reactTo() in class SendFriendRequest by creating method object
class SendFriendRequestHelper {
    String userID;
    String friendID;
    HashMap<String, String> tempUserFriendList;
    HashMap<String, String> tempFriendFriendList;
    String friendshipStatus;

    String msg = "Friend request sent";
    Boolean updated = false;
    final static int FRIEND_LIMIT = 10;

    /**
     * a helper that take actions based on the friendship status between user and friend, see inline comments for details
     * @param requestModel the input data containing user's ID (username), friend's ID and user's friendList
     * @param tempFriendFriendList the friend's friendList
     */
    SendFriendRequestHelper(FriendManagerRequestModel requestModel, HashMap<String, String> tempFriendFriendList) {
        this.userID = requestModel.getUserID();
        this.friendID = requestModel.getFriendID();
        this.tempUserFriendList = requestModel.getUserFriendList();
        this.tempFriendFriendList = tempFriendFriendList;

        if (tempUserFriendList != null) {
            this.friendshipStatus = tempUserFriendList.get(friendID);
        } else {
            tempUserFriendList = new HashMap<>();
        }
    }

    void handleFriendRequest() {
        //check if there is pending / existed friendship between userID and friendID
        if (friendshipStatus != null) {
            handleExistedFriendshipStatus();
        } else {
            handleNewFriendshipStatus();
        }
    }

    void changeFriendList() {
        if (Objects.equals(msg, "Friend request sent")) {
            //no friendshipStatus between userID and friendID, create new pending friend request
            tempUserFriendList.put(friendID, "pending_" + userID);
            tempFriendFriendList.put(userID, "pending_" + userID);
        } else { //both userID and friendID try to be friends, change friendList for both
            tempUserFriendList.put(friendID, "friend");
            tempFriendFriendList.put(userID, "friend");
        }
        updated = true;

    }

    void handleExistedFriendshipStatus() {
        // check if the user has reached the friend limit
        if (tempUserFriendList.size() == FRIEND_LIMIT) {
            msg = "you've reached the friend limit of 10"; }
        // decide msg given the friendshipStatus of pending friend request exists / already friends
        else if (Objects.equals(friendshipStatus, "friend")) {
            msg = "You are already friends with " + friendID;
        } else if (Objects.equals(friendshipStatus, "pending_" + userID)) {
            msg = "Please do not send repeated friend request";
        } else {
            msg = "You are now friends with "  + friendID;
            changeFriendList();
        }
    }

    void handleNewFriendshipStatus() {
        // not a friend & no pending friend request, calls changeFriendList() to create new friend request
        changeFriendList();
    }

    HashMap<String, String> getTempFriendFriendList() {
        return tempFriendFriendList;
    }

    HashMap<String, String> getTempUserFriendList() {
        return tempUserFriendList;
    }

    String getFriendID() {
        return friendID;
    }

    String getUserID() {
        return userID;
    }

    Boolean getUpdated() { return updated; }

    String getMsg() { return msg; }

}

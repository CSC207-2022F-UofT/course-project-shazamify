package user_interaction.user_interact_abr.friend_manager_abr;

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

    SendFriendRequestHelper(FriendManagerRequestModel requestModel) {
        this.userID = requestModel.getUserID();
        this.friendID = requestModel.getFriendID();
        this.tempUserFriendList = requestModel.getUserFriendList();
        this.tempFriendFriendList = requestModel.getFriendFriendList();
        this.friendshipStatus = tempUserFriendList.get(friendID);
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
        // decide msg given the friendshipStatus of pending friend request exists / already friends
        if (Objects.equals(friendshipStatus, "friend")) {
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

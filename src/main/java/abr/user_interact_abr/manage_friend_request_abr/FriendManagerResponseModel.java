package abr.user_interact_abr.manage_friend_request_abr;

import java.util.HashMap;

public class FriendManagerResponseModel {
    private final String msg;

    private final HashMap<String, String> friendList;

    public FriendManagerResponseModel (String msg, HashMap<String, String> friendList){
        this.friendList = friendList;
        this.msg = msg;
    }

    public String getMsgToDisplay(){
        return msg;
    }

    public HashMap<String, String> getFriendList() {
        return friendList;
    }
}

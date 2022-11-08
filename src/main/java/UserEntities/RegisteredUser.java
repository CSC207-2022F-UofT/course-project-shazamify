package UserEntities;

import java.util.HashMap;

public class RegisteredUser extends User{

    private String userID;
    private String password;
    private HashMap<String, String> friendList;


    RegisteredUser(String pswd, String userid){
        this.password = pswd;
        this.userID = userid;
    }

    public String getUserID() {
        return userID;
    }

    public HashMap<String, String> getFriendList() {
        return friendList;
    }
}

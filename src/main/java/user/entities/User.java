package user.entities;

import java.io.Serializable;
import java.util.HashMap;

public interface User extends Serializable {
    int getUserID();
    String getUserName();
    String getPassword();
    HashMap<String, String> getFriendList();
    void setFriendList(HashMap <String, String> newFriendList);
}

package interface_adaptors.user_login_ia;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserStatusViewModel {
    String userName;
    String passWord;
    BufferedImage userAvatar;
    LocalDateTime accountCreateTime;
    HashMap<String, String> friendList = new HashMap<>();
    List<UserStatusObserver> userStatusObservers = new ArrayList<>();

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setAccountCreateTime(LocalDateTime accountCreateTime) {
        this.accountCreateTime = accountCreateTime;
    }

    public void setUserAvatar(BufferedImage userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public BufferedImage getUserAvatar() {
        return userAvatar;
    }

    public LocalDateTime getAccountCreateTime() {
        return accountCreateTime;
    }

    public void setFriendList(HashMap<String, String> friendList) {
        this.friendList = friendList;
    }
    public HashMap<String, String> getFriendList() {
        return friendList;
    }
    public void addUserStatusObserver(UserStatusObserver userStatusObserver){
        userStatusObservers.add(userStatusObserver);
    }

    public void deleteUserStatusObserver(UserStatusObserver userStatusObserver){
        userStatusObservers.remove(userStatusObserver);
    }
    public void userUpdated(){
        for (UserStatusObserver observer : userStatusObservers){
            observer.userUpdated();
        }
    }
}

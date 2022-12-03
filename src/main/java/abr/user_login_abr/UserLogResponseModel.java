package abr.user_login_abr;

import entities.user_entities.User;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class UserLogResponseModel {
    boolean userNameValid;
    boolean userPasswordValid;
    String userName;
    String passWord;
    BufferedImage userAvatar;
    LocalDateTime accountCreateTime;
    HashMap<String, String> friendList;
    List<String> playListIDs;





    public void setValidUserName(boolean validLogin) {
        this.userNameValid = validLogin;
    }

    public void setUserPasswordValid(boolean userPasswordValid) {
        this.userPasswordValid = userPasswordValid;
    }

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

    public boolean isValidUserName() {
        return userNameValid;
    }

    public boolean isUserPasswordValid() {
        return userPasswordValid;
    }

    public void setFriendList(HashMap<String, String> friendList) {
        this.friendList = friendList;
    }

    public HashMap<String, String> getFriendList() {
        return friendList;
    }

    public List<String> getPlayListIDs() {
        return playListIDs;
    }

    public void setPlayListIDs(List<String> playListIDs) {
        this.playListIDs = playListIDs;
    }
}

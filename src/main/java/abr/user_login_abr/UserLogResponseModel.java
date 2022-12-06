package abr.user_login_abr;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserLogResponseModel {
    private boolean userNameValid;
    private boolean userPasswordValid;
    private String userName;
    private String password;
    private BufferedImage userAvatar;
    private LocalDateTime accountCreateTime;
    private HashMap<String, String> friendList;
    private List<String> playListIDs;
    private Map<String, String> securityQuestions;




    public void setValidUserName(boolean validLogin) {
        this.userNameValid = validLogin;
    }

    public void setUserPasswordValid(boolean userPasswordValid) {
        this.userPasswordValid = userPasswordValid;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPassword() {
        return password;
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

    public void setSecurityQuestions(Map<String, String> securityQuestions) {
        this.securityQuestions = securityQuestions;
    }

    public Map<String, String> getSecurityQuestions() {
        return securityQuestions;
    }
}

package interface_adaptors.user_login_ia;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserStatusViewModel {
    private String userName;
    private String passWord;
    private BufferedImage userAvatar;
    private LocalDateTime accountCreateTime;
    private HashMap<String, String> friendList = new HashMap<>();

    // This is A list of PlaylistIds(Strings) !! Not the Playlist entities itself !!
    private List<String> playListIds = new ArrayList<>();
    private final List<UserStatusObserver> userStatusObservers = new ArrayList<>();
    private Map<String, String> securityQuestions;
    private static UserStatusViewModel instance;

    public static UserStatusViewModel getInstance() {
        if(instance == null) {
            instance = new UserStatusViewModel();
        }
        return instance;
    }

    private UserStatusViewModel(){

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

    public void updateFriendList(HashMap<String, String> friendList) {
        this.friendList = friendList;
    }
    public HashMap<String, String> getFriendList() {
        return friendList;
    }

    public void setPlayListIds(List<String> playListIds) {
        this.playListIds = playListIds;
    }

    public List<String> getPlayListIds() {
        return playListIds;
    }

    public Map<String, String> getSecurityQuestions() {
        return securityQuestions;
    }
    public void setSecurityQuestions(Map<String, String> securityQuestions) {
        this.securityQuestions = securityQuestions;
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

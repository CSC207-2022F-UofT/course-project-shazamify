package entities.user_entities;

import abr.user_reg_abr.UserRegisterDataBaseGateway;
import ds.user_reg_ds.UserRegisterFileGateway;
import entities.playlist_entities.Playlist;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommonUser implements User, Serializable {
    private String userName;
    private String passWord;
    private final int userID;
    private UserSecurityQuestionPackage securityQuestionPackage;
    private UserAvatar userAvatar;
    private final LocalDateTime accountCreateTime;

    private HashMap<String, String> friendList = new HashMap<>();
    final private List<String> playlistIDs = new ArrayList<>();

    public CommonUser(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.userID = generateUserID();
        this.accountCreateTime = LocalDateTime.now();
        this.userAvatar = getDefaultAvatar();
    }

    private UserAvatar getDefaultAvatar() {
        try {
//            BufferedImage tempAvatar = ImageIO.read(new File("default_avatar.jpg"));
            // sry ;P
            BufferedImage tempAvatar = ImageIO.read(new File("src/main/resources/defaultprofilepicture.jpg"));
            userAvatar = new UserAvatar(tempAvatar);
            return userAvatar;
        } catch (IOException e){
            throw new RuntimeException("Failed to create Default Avatar");
        }
    }

    private int generateUserID() {
        UserRegisterDataBaseGateway dataBaseGateway = new UserRegisterFileGateway();
        return dataBaseGateway.getNumberOfUsers() + 1;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public void setSecurityQuestions(UserSecurityQuestionPackage securityQuestions) {
        this.securityQuestionPackage = securityQuestions;
    }

    @Override
    public UserSecurityQuestionPackage getSecurityQuestions() {
        return securityQuestionPackage;
    }

    @Override
    public int getUserID(){
        return this.userID;
    }

    @Override
    public HashMap<String, String> getFriendList() {return friendList;}

    @Override
    public void setFriendList(HashMap <String, String> newFriendList) {
        friendList = newFriendList;
    }

    public BufferedImage getUserAvatar() {
        return userAvatar.getBufferedImage();

    }

    @Override
    public LocalDateTime getAccountCreationTime() {
        return accountCreateTime;
    }

    @Override
    public void setUserAvatar(BufferedImage tempUserAvatar) {
        this.userAvatar = new UserAvatar(tempUserAvatar);
    }

    @Override
    public void setPassword(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public void addPlaylistID(String playlistID) {
        this.playlistIDs.add(playlistID);
    }
    @Override
    public void deletePlaylistID(String playlistID) {
        this.playlistIDs.remove(playlistID);
    }
    @Override
    public List<String> getPlaylistIDs() {
        return playlistIDs;
    }
}

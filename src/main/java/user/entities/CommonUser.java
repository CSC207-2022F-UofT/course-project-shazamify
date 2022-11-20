package user.entities;

import user.database.UserRegisterDataBaseGateway;
import user.database.UserRegisterFileGateway;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class CommonUser implements User, Serializable {
    private String userName;
    private String passWord;
    private final int userID;
    private UserSecurityQuestionPackage securityQuestionPackage;
    private UserAvatar userAvatar;

    private HashMap<String, String> friendList = new HashMap<>();

    public CommonUser(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.userID = generateUserID();

        this.userAvatar = getDefaultAvatar();
    }

    private UserAvatar getDefaultAvatar() {
        try {
            BufferedImage tempAvatar = ImageIO.read(new File("default_avatar.jpg"));
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
    public void setUserAvatar(UserAvatar avatar) {
        this.userAvatar = avatar;
    }
}

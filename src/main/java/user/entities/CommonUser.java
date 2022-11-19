package user.entities;

import user.database.UserRegisterDataBaseGateway;
import user.database.UserRegisterFileGateway;

import java.io.Serializable;
import java.util.HashMap;

public class CommonUser implements User, Serializable {
    private String userName;
    private String passWord;
    private final int userID;
    private UserSecurityQuestionPackage securityQuestionPackage;

    private HashMap<String, String> friendList = new HashMap<>();

    public CommonUser(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
        this.userID = generateUserID();
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


}

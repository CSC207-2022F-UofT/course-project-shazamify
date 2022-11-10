package user.entities;

import user.database.UserDataBaseGateway;
import user.database.UserFileGateway;

import java.io.Serializable;

public class CommonUser implements User, Serializable {
    private String userName;
    private String passWord;
    private final int userID;

    public CommonUser(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
        this.userID = generateUserID();
    }

    private int generateUserID() {
        UserDataBaseGateway dataBaseGateway = new UserFileGateway();
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
    public int getUserID(){
        return this.userID;
    }
}

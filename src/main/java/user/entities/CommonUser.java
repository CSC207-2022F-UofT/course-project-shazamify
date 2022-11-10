package user.entities;

import user.database.UserRegisterDataBaseGateway;
import user.database.UserRegisterFileGateway;

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
    public int getUserID(){
        return this.userID;
    }
}

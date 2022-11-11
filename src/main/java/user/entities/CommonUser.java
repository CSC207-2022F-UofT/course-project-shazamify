package user.entities;

import java.io.Serializable;

public class CommonUser implements User, Serializable {
    private String userName;
    private String passWord;

    public CommonUser(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
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
}

package user.database;

import java.io.IOException;

public interface UserDataBaseGateway {
    boolean checkAndRegisterUser(String userName, String passWord);
    boolean checkValidPassword(String userName, String passWord);
    boolean checkValidUserName(String userName);
    int getNumberOfUsers();
    void clearDatabase();
}

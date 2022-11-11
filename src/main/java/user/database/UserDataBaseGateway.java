package user.database;

import java.io.IOException;

public interface UserDataBaseGateway {
    boolean checkAndRegisterUser(String userName, String passWord);
    boolean checkValidLogin(String userName, String passWord);
}

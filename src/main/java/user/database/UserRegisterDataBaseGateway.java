package user.database;

import user.entities.UserSecurityQuestionPackage;

import java.util.Map;

public interface UserRegisterDataBaseGateway {
    // This interface is responsible for UserRegister to handle UserData
    boolean checkAndRegisterUser(String userName, String passWord, UserSecurityQuestionPackage securityQuestionPackage);

    int getNumberOfUsers();
    void clearDatabase();
}

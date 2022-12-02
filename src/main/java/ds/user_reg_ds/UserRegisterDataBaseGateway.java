package ds.user_reg_ds;

import import entities.user_entities.User;SecurityQuestionPackage;

public interface UserRegisterDataBaseGateway {
    // This interface is responsible for UserRegister to handle UserData
    boolean checkAndRegisterUser(String userName, String passWord, UserSecurityQuestionPackage securityQuestionPackage);

    int getNumberOfUsers();
    void clearDatabase();
}

package abr.user_reg_abr;

import entities.user_entities.UserSecurityQuestionPackage;

public interface UserRegisterDataBaseGateway {
    // This interface is responsible for UserRegister to handle UserData
    boolean checkAndRegisterUser(String userName, String passWord, UserSecurityQuestionPackage securityQuestionPackage);

    int getNumberOfUsers();
    void clearDatabase();
}

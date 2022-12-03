package user_unit_test.testing_tools;

import abr.user_reg_abr.UserRegisterDataBaseGateway;
import ds.user_reg_ds.UserRegisterFileGateway;
/**
 @author David Li
 */
public class UserDataBaseEraser {

    /**
     * Erase the UserDatabase
     */
    public static void eraseUserDataBase(){
        UserRegisterDataBaseGateway userRegisterDataBaseGateway = new UserRegisterFileGateway();
        userRegisterDataBaseGateway.clearDatabase();
    }
}

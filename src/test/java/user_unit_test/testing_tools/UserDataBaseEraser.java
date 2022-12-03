package user_unit_test.testing_tools;

import abr.user_reg_abr.UserRegisterDataBaseGateway;
import ds.user_reg_ds.UserRegisterFileGateway;

public class UserDataBaseEraser {
    public static void eraseUserDataBase(){
        UserRegisterDataBaseGateway userRegisterDataBaseGateway = new UserRegisterFileGateway();
        userRegisterDataBaseGateway.clearDatabase();
    }
}

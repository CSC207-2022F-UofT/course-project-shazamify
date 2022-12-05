package user_unit_test.testing_tools;

import interface_adaptors.user_reg_ia.UserRegViewModel;

/**
 * @author David Li
 *
 * Warning: By running this generation, all data inside the database will be erased and replace.
 */
public class GenerateTenUsersDatabase {
    /**
     * The format of the generated User data will be:
     * Username[0:10) and Password [0:10)
     * Username and Password will be the same
     */
    public static void generateTenUserDatabase(){
        UserDataBaseEraser.eraseUserDataBase();
        for(int i=0; i<10; i++){
            String userName = String.valueOf(i);
            String passWord = String.valueOf(i);

            UserRegTestingTools.registerUser(userName, passWord, passWord);
        }
    }
}

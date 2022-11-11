package user.unit_test.login;

import org.junit.Test;
import user.database.UserDataBaseGateway;
import user.database.UserFileGateway;

public class UserLogDatabaseUnitTest {
    @Test
    public void UserLogDatabaseCorrect1(){
        UserDataBaseGateway dataBaseGateway = new UserFileGateway();
        dataBaseGateway.clearDatabase();
        dataBaseGateway.checkAndRegisterUser("222", "222");
        assert dataBaseGateway.checkValidUserName("222");
        assert dataBaseGateway.checkValidPassword("222","222");
    }
    @Test
    public void UserLogDatabasePasswordIncorrect1(){
        UserDataBaseGateway dataBaseGateway = new UserFileGateway();
        dataBaseGateway.clearDatabase();
        dataBaseGateway.checkAndRegisterUser("222", "222");
        assert !dataBaseGateway.checkValidPassword("222","333");
    }
    @Test
    public void UserLogDatabaseUserNameIncorrect1(){
        UserDataBaseGateway dataBaseGateway = new UserFileGateway();
        dataBaseGateway.clearDatabase();
        dataBaseGateway.checkAndRegisterUser("222", "222");
        assert !dataBaseGateway.checkValidUserName("333");
    }
}

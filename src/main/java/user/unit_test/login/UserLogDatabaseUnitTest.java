package user.unit_test.login;


import org.junit.Test;
import user.database.UserLoginDataBaseGateway;
import user.database.UserLoginFileGateway;
import user.database.UserRegisterDataBaseGateway;
import user.database.UserRegisterFileGateway;

public class UserLogDatabaseUnitTest {
    @Test
    public void UserLogDatabaseCorrect1(){
        UserLoginDataBaseGateway dataBaseGateway = new UserLoginFileGateway();
        UserRegisterDataBaseGateway registerGateway = new UserRegisterFileGateway();
        dataBaseGateway.clearDatabase();
        registerGateway.checkAndRegisterUser("222", "222");
        assert dataBaseGateway.checkValidUserName("222");
        assert dataBaseGateway.checkValidPassword("222","222");
    }
    @Test
    public void UserLogDatabasePasswordIncorrect1(){
        UserLoginDataBaseGateway dataBaseGateway = new UserLoginFileGateway();
        UserRegisterDataBaseGateway registerGateway = new UserRegisterFileGateway();
        dataBaseGateway.clearDatabase();
        registerGateway.checkAndRegisterUser("222", "222");
        assert !dataBaseGateway.checkValidPassword("222","333");
    }
    @Test
    public void UserLogDatabaseUserNameIncorrect1(){
        UserLoginDataBaseGateway dataBaseGateway = new UserLoginFileGateway();
        UserRegisterDataBaseGateway registerGateway = new UserRegisterFileGateway();
        dataBaseGateway.clearDatabase();
        registerGateway.checkAndRegisterUser("222", "222");
        assert !dataBaseGateway.checkValidUserName("333");
    }
}

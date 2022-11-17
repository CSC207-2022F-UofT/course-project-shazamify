package user.database;

public interface UserRegisterDataBaseGateway {
    // This interface is responsible for UserRegister to handle UserData
    boolean checkAndRegisterUser(String userName, String passWord);

    int getNumberOfUsers();
    void clearDatabase();
}

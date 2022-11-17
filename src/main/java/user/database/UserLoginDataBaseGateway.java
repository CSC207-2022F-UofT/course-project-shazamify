package user.database;

public interface UserLoginDataBaseGateway {
    // This interface is responsible for UserLogin to handle UserData
    boolean checkValidPassword(String userName, String passWord);

    boolean checkValidUserName(String userName);
    int getNumberOfUsers();
    void clearDatabase();
}
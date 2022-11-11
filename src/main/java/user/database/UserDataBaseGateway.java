package user.database;

public interface UserDataBaseGateway {
    boolean checkAndRegisterUser(String userName, String passWord);
    boolean checkValidPassword(String userName, String passWord);
    boolean checkValidUserName(String userName);
    int getNumberOfUsers();
    void clearDatabase();
}

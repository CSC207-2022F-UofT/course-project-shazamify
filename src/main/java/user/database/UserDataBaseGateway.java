package user.database;

public interface UserDataBaseGateway {
    public boolean checkAndRegisterUser(String userName, String passWord);
    public boolean checkValidLogin(String userName);
}

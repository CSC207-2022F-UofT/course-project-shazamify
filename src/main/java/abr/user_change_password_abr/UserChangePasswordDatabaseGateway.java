package abr.user_change_password_abr;

public interface UserChangePasswordDatabaseGateway {
    void changePassword(String userName, String passWord);
}

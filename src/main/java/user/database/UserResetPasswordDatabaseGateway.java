package user.database;

import user.entities.User;

public interface UserResetPasswordDatabaseGateway {
    User ResetPassword(String userName, String passWord);
}

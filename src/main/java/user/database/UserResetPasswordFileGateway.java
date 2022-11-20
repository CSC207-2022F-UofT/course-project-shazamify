package user.database;

import user.entities.User;

import java.util.Map;

public class UserResetPasswordFileGateway implements UserResetPasswordDatabaseGateway{

    @Override
    public User ResetPassword(String userName, String passWord) {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        User user = userMap.get(userName);
        user.setPassword(passWord);
        userMap.put(userName, user);
        return user;
    }
}

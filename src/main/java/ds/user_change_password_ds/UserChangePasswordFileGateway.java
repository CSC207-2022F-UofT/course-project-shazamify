package ds.user_change_password_ds;

import abr.user_change_password_abr.UserChangePasswordDatabaseGateway;
import ds.user_database.UserFileReader;
import ds.user_database.UserFileWriter;
import entities.user_entities.User;

import java.util.Map;

public class UserChangePasswordFileGateway implements UserChangePasswordDatabaseGateway {
    @Override
    public void changePassword(String userName, String passWord) {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        // If user user_database contain user
        if (userMap.containsKey(userName)){
            // retrieve user from user_database
            User user = userMap.get(userName);
            // Set user Password to given avatar
            user.setPassword(passWord);
            userMap.put(userName, user);
            UserFileWriter.writeUserMap(userMap,"UserDatabase.ser" );
        } else{
            throw new RuntimeException("User name not found when changing the Password");
        }
    }
}

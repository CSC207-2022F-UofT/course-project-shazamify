package user.avatar_image_management.DS;

import user.avatar_image_management.DS.UserAvatarDatabaseGateway;
import user.database.UserFileReader;
import user.database.UserFileWriter;
import user.entities.User;
import user.entities.UserAvatar;

import java.util.HashMap;
import java.util.Map;

public class UserAvatarFileGateway implements UserAvatarDatabaseGateway {


    @Override
    public User getUser(String userName) {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return userMap.get(userName);
    }

    /**
     * Change the avatar inside the database, if userName not found, return false;
     * @param userName Username
     * @param avatar Avatar Image
     * @return if the userName inside the database
     */
    @Override
    public User changeAvatar(String userName, UserAvatar avatar) {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        // If user database contain user
        if (userMap.containsKey(userName)){
            // retrieve user from database
            User user = userMap.get(userName);
            // Set user Avatar to given avatar
            user.setUserAvatar(avatar);
            userMap.put(userName, user);
            // Return the user;
            return user;
        } else{
            throw new RuntimeException("User name not found when changing the Avatar");
        }
    }

    @Override
    public void clearDatabase() {
        UserFileWriter.writeUserMap(new HashMap<>(), "UserDatabase.ser");
    }
}

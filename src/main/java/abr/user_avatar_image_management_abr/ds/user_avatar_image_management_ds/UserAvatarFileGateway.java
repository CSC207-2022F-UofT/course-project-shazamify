package abr.user_avatar_image_management_abr.ds.user_avatar_image_management_ds;

import abr.user_avatar_image_management_abr.UserAvatarDatabaseGateway;
import abr.user_avatar_image_management_abr.ds.user_database.UserFileReader;
import abr.user_avatar_image_management_abr.ds.user_database.UserFileWriter;
import entities.user_entities.User;
import entities.user_entities.UserAvatar;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class UserAvatarFileGateway implements UserAvatarDatabaseGateway {


    @Override
    public User getUser(String userName) {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        return userMap.get(userName);
    }

    /**
     * Change the avatar inside the user_database, if userName not found, return false;
     * @param userName Username
     * @param tempUserAvatar The buffered image of the UserAvatar
     * @return if the userName inside the user_database
     */
    @Override
    public User changeAvatar(String userName, BufferedImage tempUserAvatar) {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        // If user user_database contain user
        if (userMap.containsKey(userName)){
            // retrieve user from user_database
            User user = userMap.get(userName);
            // Set user Avatar to given avatar
            user.setUserAvatar(tempUserAvatar);
            userMap.put(userName, user);
            UserFileWriter.writeUserMap(userMap,"UserDatabase.ser" );
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

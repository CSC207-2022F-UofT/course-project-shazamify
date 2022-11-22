package ds.user_avatar_image_management_ds;

import entities.user_entities.User;
import entities.user_entities.UserAvatar;

public interface UserAvatarDatabaseGateway {
    User getUser(String userName);
    User changeAvatar(String userName, UserAvatar avatar);
    void clearDatabase();
}

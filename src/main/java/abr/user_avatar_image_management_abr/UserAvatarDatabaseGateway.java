package abr.user_avatar_image_management_abr;

import import entities.user_entities.User;;
import import entities.user_entities.User;Avatar;

public interface UserAvatarDatabaseGateway {
    User getUser(String userName);
    User changeAvatar(String userName, UserAvatar avatar);
    void clearDatabase();
}

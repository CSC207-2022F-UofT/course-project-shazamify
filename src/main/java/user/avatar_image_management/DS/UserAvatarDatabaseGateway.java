package user.avatar_image_management.DS;

import user.entities.User;
import user.entities.UserAvatar;

public interface UserAvatarDatabaseGateway {
    User getUser(String userName);
    User changeAvatar(String userName, UserAvatar avatar);
    void clearDatabase();
}

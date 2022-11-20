package user.database;

import user.entities.User;
import user.entities.UserAvatar;

public interface UserAvatarDatabaseGateway {
    User getUser(String userName);
    User changeAvatar(String userName, UserAvatar avatar);
    void clearDatabase();
}

package abr.user_avatar_image_management_abr;

import entities.user_entities.User;
import entities.user_entities.UserAvatar;

import java.awt.image.BufferedImage;

public interface UserAvatarDatabaseGateway {
    User getUser(String userName);
    User changeAvatar(String userName, BufferedImage tempUserAvatar);
    void clearDatabase();
}

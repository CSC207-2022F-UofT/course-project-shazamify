package entities.user_entities;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

public interface User extends Serializable {
    int getUserID();
    String getUserName();
    String getPassword();
    void setSecurityQuestions(UserSecurityQuestionPackage securityQuestions);
    UserSecurityQuestionPackage getSecurityQuestions();
    HashMap<String, String> getFriendList();
    void setFriendList(HashMap <String, String> newFriendList);
    BufferedImage getUserAvatar();
    LocalDateTime getAccountCreationTime();
    void setUserAvatar(UserAvatar avatar);
    void setPassword(String passWord);
}

package entities.user_entities;

import entities.playlist_entities.Playlist;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

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
    void setUserAvatar(BufferedImage tempUserAvatar);
    void setPassword(String passWord);
    void addPlaylistID(String playlistID);
    void deletePlaylistID(String playlistID);
    List<String> getPlaylistIDs();
}

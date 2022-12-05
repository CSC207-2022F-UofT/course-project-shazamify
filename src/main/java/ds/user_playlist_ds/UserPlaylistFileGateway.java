package ds.user_playlist_ds;

import abr.user_playlist_abr.UserPlaylistDatabaseGateway;
import ds.user_database.UserFileReader;
import ds.user_database.UserFileWriter;
import entities.user_entities.User;

import java.util.List;
import java.util.Map;

public class UserPlaylistFileGateway implements UserPlaylistDatabaseGateway {
    @Override
    public List<String> addPlaylistInUser(String userName, String playListID) {
        // Retrive the database
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        // get the user from the database
        User user = userMap.get(userName);
        // Add playlist into List of playlist
        user.addPlaylistID(playListID);
        // mutate the user in userMap
        userMap.put(userName, user);
        // write the userMap into the database
        UserFileWriter.writeUserMap(userMap, "UserDatabase.ser");
        return user.getPlaylistIDs();
    }

    @Override
    public List<String> deletePlaylistInUser(String userName, String playListID) {
        Map<String, User> userMap = UserFileReader.getUserMap("UserDatabase.ser");
        // get the user from the database
        User user = userMap.get(userName);
        // Delete playlist from the List of Playlist
        try {
            user.deletePlaylistID(playListID);
        } catch (RuntimeException e){
            throw new RuntimeException("Playlist can not found in User Playlist");
        }
        // mutate the user in userMap
        userMap.put(userName, user);
        // write the userMap into the database
        UserFileWriter.writeUserMap(userMap, "UserDatabase.ser");
        return user.getPlaylistIDs();
    }
}

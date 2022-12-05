package abr.user_playlist_abr;

import java.util.List;

public interface UserPlaylistDatabaseGateway {
    List<String> addPlaylistInUser(String userName, String playListID);
    List<String> deletePlaylistInUser(String userName, String playListID);
}

package abr.user_playlist_abr;

import java.util.List;

public class UserPlaylistResponseModel {
    List<String> userPlaylistIDs;

    public List<String> getUserPlaylistIDs() {
        return userPlaylistIDs;
    }

    public void setUserPlaylistIDs(List<String> userPlaylistIDs) {
        this.userPlaylistIDs = userPlaylistIDs;
    }
}

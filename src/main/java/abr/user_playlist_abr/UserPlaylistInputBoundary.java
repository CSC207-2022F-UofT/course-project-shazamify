package abr.user_playlist_abr;

public interface UserPlaylistInputBoundary {
    void addToUserPlaylist(UserPlaylistRequestModel userPlaylistRequestModel);
    void deleteInUserPlaylist(UserPlaylistRequestModel userPlaylistRequestModel);
}

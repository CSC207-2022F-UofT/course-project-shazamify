package abr.playlist_abr;

public interface PlaylistModifyInputBoundary {

    void addToPlaylist(PlaylistModifyRequestModel requestModel);
    void deleteSong(PlaylistModifyRequestModel requestModel);
    void setPrivacy(PlaylistModifyRequestModel requestModel);
    void setName(PlaylistModifyRequestModel requestModel);
    void reOrderPL (PlaylistModifyRequestModel requestModel);
}

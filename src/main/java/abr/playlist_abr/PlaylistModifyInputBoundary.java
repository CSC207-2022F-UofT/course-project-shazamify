package abr.playlist_abr;

public interface PlaylistModifyInputBoundary {
    /**
     * add a song to the playlist
     * @param requestModel: modify Playlist's properties
     */
    void addToPlaylist(PlaylistModifyRequestModel requestModel);

    /**
     * delete the song from the playlist
     * @param requestModel: modify Playlist's properties
     */
    void deleteSong(PlaylistModifyRequestModel requestModel);

    /**
     * change the privacy of current Playlist
     * @param requestModel: modify Playlist's properties
     */
    void setPrivacy(PlaylistModifyRequestModel requestModel);

    /**
     * change the name of current playlist
     * @param requestModel: modify Playlist's properties
     */
    void setName(PlaylistModifyRequestModel requestModel);

    /**
     * reorder the Playlist's contents
     * @param requestModel: modify Playlist's properties
     */
    void reOrderPL (PlaylistModifyRequestModel requestModel);
}

package abr.playlist_abr;

/**
 * Reserved for PlaylistCreateControl to provide playlistCreate function
 */
public interface PlaylistCreateInputBoundary {
    /** building the gap between PlaylistCreateUseCase and PlaylistCreateControl
     *
     * @return DS containing params for RecordViewModel
     */
    PlaylistResponseModel playlistCreate(String name);
}

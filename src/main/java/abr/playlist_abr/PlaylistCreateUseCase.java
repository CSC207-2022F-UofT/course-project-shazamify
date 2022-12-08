package abr.playlist_abr;

import entities.playlist_entities.Playlist;
import org.bson.types.ObjectId;

public class PlaylistCreateUseCase implements PlaylistCreateInputBoundary {
    private final PlaylistDAOInput playlistDAOInput;


    /** containing PlaylistCreate's logic
     *
     *
     * @param playlistDAOInput
     */
    public PlaylistCreateUseCase(PlaylistDAOInput playlistDAOInput){
        this.playlistDAOInput = playlistDAOInput;
    }

    /** Create the playlist's logic
     *
     * @return Playlist but in Response Model
     */
    public PlaylistResponseModel playlistCreate(String name){
        ObjectId id = new ObjectId();
        Playlist newPlaylist = new Playlist(id.toString());
        newPlaylist.setName(name);
        playlistDAOInput.save(newPlaylist);
        PlaylistResponseModel playlistResM = new PlaylistResponseModel(newPlaylist.getId());
        //TODO: updateView(playlistResM)
        return playlistResM;
    }

}

package abr.playlist_abr;

import entities.playlist_entities.Playlist;
import org.bson.types.ObjectId;

public class PlaylistCreateUseCase implements PlaylistCreateInputBoundary {
    private final PlaylistDAOInput playlistDAOInput;
    private final PlaylistCreateOutputBoundary outputBoundary;


    public PlaylistCreateUseCase(PlaylistCreateOutputBoundary outputBoundary, PlaylistDAOInput playlistDAOInput){
        this.outputBoundary = outputBoundary;
        this.playlistDAOInput = playlistDAOInput;

    }

    public PlaylistResponseModel playlistCreate(){
        ObjectId id = new ObjectId();
        Playlist newPlaylist = new Playlist(id.toString());
        playlistDAOInput.save(newPlaylist);
        PlaylistResponseModel playlistResM = new PlaylistResponseModel(newPlaylist.getId());
        //TODO: updateView(playlistResM)
        return playlistResM;
    }

}

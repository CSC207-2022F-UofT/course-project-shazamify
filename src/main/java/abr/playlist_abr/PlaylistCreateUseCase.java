package abr.playlist_abr;

import entities.playlist_entities.Playlist;
import org.bson.types.ObjectId;

public class PlaylistCreateUseCase implements PlaylistCreateInputBoundary {
    private final PlaylistDAOInput playlistDAOInput;
    private final PlaylistCreateOutputBoundary outputBoundary;
    private final PlaylistCreateResponseModel playlistCreateResponseModel;


    public PlaylistCreateUseCase(PlaylistCreateOutputBoundary outputBoundary, PlaylistDAOInput playlistDAOInput, PlaylistCreateResponseModel playlistCreateResponseModel){
        this.outputBoundary = outputBoundary;
        this.playlistDAOInput = playlistDAOInput;
        this.playlistCreateResponseModel = playlistCreateResponseModel;
    }

    public PlaylistCreateResponseModel playlistCreate(){
        ObjectId id = new ObjectId();
        Playlist newPlaylist = new Playlist(id.toString());
        playlistDAOInput.save(newPlaylist);
        this.playlistCreateResponseModel.setPlaylist(newPlaylist);
        this.outputBoundary.present(this.playlistCreateResponseModel);
        return this.playlistCreateResponseModel;


    }

}

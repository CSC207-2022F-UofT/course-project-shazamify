package abr.playlist_abr;

import ds.playlist_ds.PlaylistDAOInput;
import ds.playlist_ds.PlaylistDAOInputImpl;
import ds.playlist_ds.PlaylistDAOOutput;
import ds.playlist_ds.PlaylistDAOOutputImpl;
import entities.playlist_entities.Playlist;
import entities.playlist_entities.PlaylistFactory;
import interface_adaptors.playlist_ia.RecordViewModel;
import org.bson.types.ObjectId;

public class PlaylistCreateUseCase {
    private final PlaylistDAOInput playlistDAOInput;
    private final PlaylistCreateOutputBoundary outputBoundary;
    private final PlaylistFactory playlistFactory;
    private RecordViewModel recordViewModel;
    private final PlaylistDAOOutput playlistDAOOutput;

    public PlaylistCreateUseCase(PlaylistCreateOutputBoundary outputBoundary){
        this.outputBoundary = outputBoundary;
        this.playlistDAOInput = new PlaylistDAOInputImpl();
        this.playlistFactory = new PlaylistFactory();
        this.recordViewModel = new RecordViewModel();
        this.playlistDAOOutput = new PlaylistDAOOutputImpl();

    }

    public RecordViewModel playlistCreate(){
        // TODO: update RecordPresenter by convert playlist to PLResponseModel
        //  thru outputBoundary's fn
        ObjectId id = new ObjectId();
        Playlist newPlaylist = playlistFactory.create(id.toString());
        playlistDAOInput.save(newPlaylist);
        return null;


    }

}

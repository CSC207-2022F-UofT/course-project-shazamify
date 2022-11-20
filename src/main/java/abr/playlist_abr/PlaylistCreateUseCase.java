package abr.playlist_abr;

import entities.playlist_entities.Playlist;
import entities.playlist_entities.PlaylistFactory;
import screen.RecordViewModel;

public class PlaylistCreateUseCase {
    private final PlaylistDatabaseGateway databaseGateway;
    private final PlaylistCreateOutputBoundary outputBoundary;
    private final PlaylistFactory playlistFactory;
    private RecordViewModel recordViewModel;

    public PlaylistCreateUseCase(PlaylistCreateOutputBoundary outputBoundary, PlaylistDatabaseGateway databaseGateway, PlaylistFactory playlistFactory, RecordViewModel recordViewModel){
        this.outputBoundary = outputBoundary;
        this.databaseGateway = databaseGateway;
        this.playlistFactory = playlistFactory;
        this.recordViewModel = recordViewModel;
    }

    public RecordViewModel playlistCreate(){
        // TODO: update RecordPresenter by convert playlist to PLResponseModel
        //  thru outputBoundary's fn
        Playlist newPlaylist = playlistFactory.create(this.databaseGateway.getNewID());
        databaseGateway.storePlaylist(newPlaylist);
        return null;


    }

}

package abr.playlist_abr;

import entities.playlist_entities.PlaylistFactory;

public class PlaylistCreateUseCase {
    private final PlaylistDatabaseGateway databaseGateway;
    private final PlaylistCreateOutputBoundary outputBoundary;
    private final PlaylistFactory playlistFactory;
    private final PlaylistCreateResponseModel playlistCreateResponseModel;

    public PlaylistCreateUseCase(PlaylistCreateOutputBoundary outputBoundary, PlaylistDatabaseGateway databaseGateway, PlaylistFactory playlistFactory, PlaylistCreateResponseModel playlistCreateResponseModel){
        this.outputBoundary = outputBoundary;
        this.databaseGateway = databaseGateway;
        this.playlistFactory = playlistFactory;
        this.playlistCreateResponseModel = playlistCreateResponseModel;
    }

    public PlaylistCreateResponseModel playlistCreate(){
        // TODO: update RecordPresenter by convert playlist to PLResponseModel
        //  thru outputBoundary's fn
        // TODO: send playlist to PlaylistNotepadGateway
        databaseGateway.storePlaylist(playlistFactory.create(this.databaseGateway.getNewID()));
        return null;


    }

}

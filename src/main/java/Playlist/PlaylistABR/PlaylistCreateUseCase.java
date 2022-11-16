package Playlist.PlaylistABR;

import Playlist.PlaylistEntities.PlaylistFactory;

public class PlaylistCreateUseCase {
    private final PlaylistDatabaseGateway databaseGateway;
    private final PlaylistCreateOutputBoundary outputBoundary;

    public PlaylistCreateUseCase(PlaylistCreateOutputBoundary outputBoundary, PlaylistDatabaseGateway databaseGateway, PlaylistFactory playlistFactory){
        this.outputBoundary = outputBoundary;
        this.databaseGateway = databaseGateway;
    }
    public boolean playlistCreate(){
        // TODO: update RecordViewModel
        // TODO: send playlist to PlaylistNotepadGateway
        PlaylistFactory playlistFactory = null;
        playlistFactory.create(this.databaseGateway.getNewID());
        return true;


    }

}

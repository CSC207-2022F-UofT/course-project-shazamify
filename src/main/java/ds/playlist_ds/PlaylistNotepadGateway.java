package ds.playlist_ds;

import abr.playlist_abr.PlaylistDatabaseGateway;
import entities.playlist_entities.Playlist;


public class PlaylistNotepadGateway implements PlaylistDatabaseGateway {
    public int getNewID(){
        //TODO: validate ID with RecordDS
        return (int) Math.floor(Math.random() * 101);
        //return a random int from 0 to 100
    }

    public boolean storePlaylist(Playlist playlist){
        return true;
        //TODO: do the actual thing with RecordDS
    }
}

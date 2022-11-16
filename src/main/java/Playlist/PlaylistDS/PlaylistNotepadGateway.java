package Playlist.PlaylistDS;

import Playlist.PlaylistABR.PlaylistDatabaseGateway;


public class PlaylistNotepadGateway implements PlaylistDatabaseGateway {
    public int getNewID(){
        //TODO: validate ID with RecordDS
        return (int) Math.floor(Math.random() * 101);
        //return a random int from 0 to 100
    }
}

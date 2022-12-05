package abr.playlist_abr;


import entities.playlist_entities.Playlist;
import entities.playlist_entities.Privacy;

import java.util.ArrayList;

public class PlaylistResponseModel{
    private static PlaylistDAOOutput playlistDAOOutput;
    private Playlist playlist;

    public PlaylistResponseModel(String plID) {
        this.playlist = this.playlistDAOOutput.findById(plID).get();
    }


    public String getName() {return this.playlist.getName();}

    public int getDuration() {return this.playlist.getDuration();}

    public String getArtist() {return this.playlist.getArtist();}

    public ArrayList<String> getSongs() {return this.playlist.getSongs();}

    public Privacy getPrivacy() {return this.playlist.getPrivacy();}
    public String getID() {return this.playlist.getId();}







}

package abr.playlist_abr;

import entities.playlist_entities.Playlist;
import entities.playlist_entities.Privacy;

import java.util.ArrayList;

public class PlaylistCreateResponseModel {
    public Playlist playlist;

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Playlist getPlaylist() {return this.playlist;}
    public String getName() {return this.playlist.getName();}

    public int getDuration() {return this.playlist.getDuration();}

    public String getArtist() {return this.playlist.getArtist();}

    public ArrayList<String> getSongs() {return this.playlist.getSongs();}

    public Privacy getPrivacy() {return this.playlist.getPrivacy();}

    public String getID() {return this.playlist.getId();}
}

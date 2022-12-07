package abr.playlist_abr;

import entities.playlist_entities.Playlist;
import entities.playlist_entities.Privacy;

import java.util.ArrayList;

/**
 * DS containing public Playlist's attributes to pertain PlaylistCreate's output
 */
public class PlaylistCreateResponseModel {
    public Playlist playlist;

    /**
     * Set Playlist to ResponseModel
     * @param playlist: current working playlist
     */
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    /**
     *
     * @return get current RM's Playlist
     */
    public Playlist getPlaylist() {return this.playlist;}

    /**
     *
     * @return current playlist's name
     */
    public String getName() {return this.playlist.getName();}

    /**
     *
     * @return current playlist's duration
     */
    public int getDuration() {return this.playlist.getDuration();}

    /**
     *
     * @return current playlist's owner
     */
    public String getArtist() {return this.playlist.getArtist();}

    /**
     *
     * @return current playlist's contents
     */
    public ArrayList<String> getSongs() {return this.playlist.getSongs();}

    /**
     *
     * @return current playlist's privacy
     */
    public Privacy getPrivacy() {return this.playlist.getPrivacy();}

    /**
     *
     * @return current playlist's ID
     */
    public String getID() {return this.playlist.getId();}
}

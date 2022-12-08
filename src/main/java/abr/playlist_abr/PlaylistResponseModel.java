package abr.playlist_abr;


import ds.playlist_ds.PlaylistDAOOutputImpl;
import entities.playlist_entities.Playlist;
import entities.playlist_entities.Privacy;

import java.util.ArrayList;
/**
 * DS containing public Playlist's attributes to pertain PlaylistLogic's output
 */
public class PlaylistResponseModel{
    private static PlaylistDAOOutput playlistDAOOutput;
    private Playlist playlist;
    /**
     * Set Playlist to ResponseModel
     * @param plID: current working playlist
     */
    public PlaylistResponseModel(String plID) {
        this.playlistDAOOutput = new PlaylistDAOOutputImpl();
        this.playlist = this.playlistDAOOutput.findById(plID).get();
    }

    /**
     *
     * @return current playlist name
     */

    public String getName() {return this.playlist.getName();}

    /**
     *
     * @return current playlist duration
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

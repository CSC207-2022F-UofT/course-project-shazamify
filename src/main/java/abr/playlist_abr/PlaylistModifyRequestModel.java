package abr.playlist_abr;

import entities.playlist_entities.Privacy;

/**
 * provides methods to construct needed UseCase's input
 */
public class PlaylistModifyRequestModel {
    public String plID;
    public String songID;
    public int songIndex;
    public Privacy privacy;
    public String plName;

    /**
     * To add a song to a playlist
     * @param plID: playlistID
     * @param songID: songID
     */
    public void addToPlaylistRqM(String plID, String songID){
        this.plID = plID;
        this.songID = songID;
    }

    /**
     * To delete a song from a playlist
     * @param plID: PlaylistID
     * @param songID: songID
     */
    public void delSongRqM(String plID, String songID){
        this.plID = plID;
        this.songID = songID;
    }

    /**
     * to change playlist's privacy
     * @param privacy: enum of Privacy
     * @param plID: playlist ID
     */
    public void setPrivacyRqM(Privacy privacy, String plID){
        this.privacy = privacy;
        this.plID = plID;
    }

    /**
     * to change playlist's name
     * @param name: new playlist name
     * @param plID: targeted playlist ID
     */
    public void setNameRqM(String name, String plID){
        this.plName = name;
        this.plID = plID;
    }

    /**
     * to reorder Playlist's contents
     * @param plID: playlistID
     * @param songID: songID
     * @param songIndex: new songIndex
     */
    public void reOrderPlRqM(String plID, String songID, int songIndex){
        this.plID = plID;
        this.songID = songID;
        this.songIndex = songIndex;
    }

}

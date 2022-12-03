package abr.playlist_abr;

import entities.playlist_entities.Privacy;

public class PlaylistModifyRequestModel {
    public String plID;
    public String songID;
    public int songIndex;
    public Privacy privacy;
    public String plName;

    public void addToPlaylistRM(String plID, String songID){
        this.plID = plID;
        this.songID = songID;
    }

    public void delSongRM(String plID, String songID){
        this.plID = plID;
        this.songID = songID;
    }

    public void setPrivacyRM(Privacy privacy, String plID){
        this.privacy = privacy;
        this.plID = plID;
    }

    public void setNameRM(String name, String plID){
        this.plName = name;
        this.plID = plID;
    }
    public void reOrderPlRM(String plID, String songID, int songIndex){
        this.plID = plID;
        this.songID = songID;
        this.songIndex = songIndex;
    }

}

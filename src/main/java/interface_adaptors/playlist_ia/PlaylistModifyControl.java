package interface_adaptors.playlist_ia;

import abr.playlist_abr.PlaylistModifyInputBoundary;
import abr.playlist_abr.PlaylistModifyRequestModel;
import entities.playlist_entities.Privacy;

public class PlaylistModifyControl {
    private final PlaylistModifyInputBoundary playlistModifyInputBoundary;

    public PlaylistModifyControl (PlaylistModifyInputBoundary playlistModifyInputBoundary){
        this.playlistModifyInputBoundary = playlistModifyInputBoundary;
    }
    // UPDATE REQUEST MODEL BASED ON WHAT YOU NEED
    public void addToPlaylist (String plID, String songID){
        PlaylistModifyRequestModel rm = new PlaylistModifyRequestModel();
        rm.addToPlaylistRM(plID, songID);
        this.playlistModifyInputBoundary.addToPlaylist(rm);
    }

    public void deleteSong (String plID, String songID){
        PlaylistModifyRequestModel rm = new PlaylistModifyRequestModel();
        rm.delSongRM(plID, songID);
        this.playlistModifyInputBoundary.deleteSong(rm);
    }

    public void setPrivacy(Privacy privacy, String plID){
        PlaylistModifyRequestModel rm = new PlaylistModifyRequestModel();
        rm.setPrivacyRM(privacy, plID);
        this.playlistModifyInputBoundary.setPrivacy(rm);

    }
    public void setName(String name, String plID){
        PlaylistModifyRequestModel rm = new PlaylistModifyRequestModel();
        rm.setNameRM(name, plID);
        this.playlistModifyInputBoundary.setName(rm);

    }

    public void reOrderPl(String plID, String songID, int songIndex){
        PlaylistModifyRequestModel rm = new PlaylistModifyRequestModel();
        rm.reOrderPlRM(plID, songID, songIndex);
        this.playlistModifyInputBoundary.reOrderPL(rm);
    }
}

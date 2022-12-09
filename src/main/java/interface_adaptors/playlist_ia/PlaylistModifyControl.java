package interface_adaptors.playlist_ia;

import abr.playlist_abr.PlaylistDAOOutput;
import abr.playlist_abr.PlaylistModifyInputBoundary;
import abr.playlist_abr.PlaylistModifyRequestModel;
import abr.playlist_abr.PlaylistModifyUseCase;
import abr.song_abr.SongDAOOutput;
import ds.playlist_ds.PlaylistDAOOutputImpl;
import ds.song_ds.SongDAOOutputImpl;
import entities.playlist_entities.Privacy;

/**
 * functionalities to modify the Playlist
 */
public class PlaylistModifyControl {
    private final PlaylistModifyInputBoundary playlistModifyInputBoundary;

    public PlaylistModifyControl (){
        PlaylistDAOOutput dao1 = new PlaylistDAOOutputImpl();
        SongDAOOutput dao2 = new SongDAOOutputImpl();
        this.playlistModifyInputBoundary = new PlaylistModifyUseCase(dao1, dao2);
    }
    // UPDATE REQUEST MODEL BASED ON WHAT YOU NEED
    public void addToPlaylist (String plID, String songID){
        PlaylistModifyRequestModel rm = new PlaylistModifyRequestModel();
        rm.addToPlaylistRqM(plID, songID);
        this.playlistModifyInputBoundary.addToPlaylist(rm);
    }

    public void deleteSong (String plID, String songID){
        PlaylistModifyRequestModel rm = new PlaylistModifyRequestModel();
        rm.delSongRqM(plID, songID);
        this.playlistModifyInputBoundary.deleteSong(rm);
    }

    public void setPrivacy(Privacy privacy, String plID){
        PlaylistModifyRequestModel rm = new PlaylistModifyRequestModel();
        rm.setPrivacyRqM(privacy, plID);
        this.playlistModifyInputBoundary.setPrivacy(rm);

    }
    public void setName(String name, String plID){
        PlaylistModifyRequestModel rm = new PlaylistModifyRequestModel();
        rm.setNameRqM(name, plID);
        this.playlistModifyInputBoundary.setName(rm);

    }

    public void reOrderPl(String plID, String songID, int songIndex){
        PlaylistModifyRequestModel rm = new PlaylistModifyRequestModel();
        rm.reOrderPlRqM(plID, songID, songIndex);
        this.playlistModifyInputBoundary.reOrderPL(rm);
    }
}

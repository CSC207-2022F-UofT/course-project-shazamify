package abr;

import abr.playlist_abr.PlaylistDAOOutput;
import abr.song_abr.SongDAOOutput;
import ds.playlist_ds.PlaylistDAOOutputImpl;
import ds.song_ds.SongDAOOutputImpl;
import entities.Song;
import entities.playlist_entities.Playlist;

import java.awt.*;

public class PlaylistDTOUseCase {
    public static String getName(String id){
        PlaylistDAOOutput playlistdaoout = new PlaylistDAOOutputImpl();
        Playlist s = playlistdaoout.findById(id).get();
        return s.getName();
    }
    public static String getArtist(String id){
        //TODO: access Playlist by id return their Artist attribute)
    }
    public static Image getCover(String id){
        //TODO: access Playlist by id return their Cover attribute)
    }
    public static String getYear(String id){
        //TODO: access Playlist by id return their year attribute)
    }
}

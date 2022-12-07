package abr;

import abr.playlist_abr.PlaylistDAOOutput;
import abr.song_abr.SongDAOOutput;
import ds.playlist_ds.PlaylistDAOOutputImpl;
import ds.song_ds.SongDAOOutputImpl;
import entities.Song;
import entities.playlist_entities.Playlist;

import java.awt.*;

public class PlaylistDTOUseCase {
    public static String getName(String id) {
        PlaylistDAOOutput playlistdaoout = new PlaylistDAOOutputImpl();
        return playlistdaoout.findById(id).get().getName();
    }

    public static String getArtist(String id) {
        SongDAOOutput playlistdaoout = new SongDAOOutputImpl();
        return playlistdaoout.findById(id).get().getArtist();
    }

    public static String getCover(String id) {
        SongDAOOutput playlistdaoout = new SongDAOOutputImpl();
        return playlistdaoout.findById(id).get().getCover();
    }

    public static String getYear(String id) {
        SongDAOOutput playlistdaoout = new SongDAOOutputImpl();
        return playlistdaoout.findById(id).get().getYear();
    }
}

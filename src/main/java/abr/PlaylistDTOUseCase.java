package abr;

import abr.playlist_abr.PlaylistDAOOutput;
import ds.playlist_ds.PlaylistDAOOutputImpl;

import java.io.File;
import java.util.List;

public class PlaylistDTOUseCase {
    public static String getName(String id) {
        PlaylistDAOOutput playlistdaoout = new PlaylistDAOOutputImpl();
        return playlistdaoout.findById(id).get().getName();
    }

    public static String getArtist(String id) {
        PlaylistDAOOutput playlistdaoout = new PlaylistDAOOutputImpl();
        return playlistdaoout.findById(id).get().getArtist();
    }

    public static File getCover(String id) {
        PlaylistDAOOutput playlistdaoout = new PlaylistDAOOutputImpl();
        return playlistdaoout.findById(id).get().getCover();
    }

    public static List<String> getSongs(String id){
        PlaylistDAOOutput playlistdaoout = new PlaylistDAOOutputImpl();
        return playlistdaoout.findById(id).get().getSongs();
    }

//    public static String getYear(String id) {
//        PlaylistDAOOutput playlistdaoout = new PlaylistDAOOutputImpl();
//        return playlistdaoout.findById(id).get().getYear();
//    }
}

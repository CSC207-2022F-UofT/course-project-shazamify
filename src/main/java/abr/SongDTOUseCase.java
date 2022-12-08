package abr;

import abr.song_abr.SongDAOOutput;
import ds.song_ds.SongDAOOutputImpl;

public class SongDTOUseCase {
    public static String getName(String id) {
        SongDAOOutput songdaoout = new SongDAOOutputImpl();
        return songdaoout.findById(id).get().getName();
    }

    public static String getArtist(String id) {
        SongDAOOutput songdaoout = new SongDAOOutputImpl();
        return songdaoout.findById(id).get().getArtist();
    }

    public static String getCover(String id) {
        SongDAOOutput songdaoout = new SongDAOOutputImpl();
        return songdaoout.findById(id).get().getCoverPath();
    }

    public static String getYear(String id) {
        SongDAOOutput songdaoout = new SongDAOOutputImpl();
        return songdaoout.findById(id).get().getYear();
    }

    public static String getFilePath(String id) {
        SongDAOOutput songdaoout = new SongDAOOutputImpl();
        if (songdaoout.findById(id).isPresent()) {
            System.out.println("Song found");
            return songdaoout.findById(id).get().getFilePath();
        } else {
            System.out.println("Song not found");
            return null;
        }

    }

    public static int getDuration(String id) {
        SongDAOOutput songdaoout = new SongDAOOutputImpl();
        return songdaoout.findById(id).get().getDuration();
    }
}

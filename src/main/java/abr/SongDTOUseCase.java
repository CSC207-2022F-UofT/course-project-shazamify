package abr;

import abr.song_abr.SongDAOOutput;
import ds.song_ds.SongDAOOutputImpl;
import entities.Song;

import java.awt.*;

public class SongDTOUseCase {
    public static String getName(String id){
        SongDAOOutput songdaoout = new SongDAOOutputImpl();
        Song s = songdaoout.findById(id).get();
        return s.getName();
    }
    public static String getArtist(String id){
        //TODO: access Record by id (so Playlist or Song DAO) return their Artist attribute)
    }
    public static Image getCover(String id){
        //TODO: access Record by id (so Playlist or Song DAO) return their Cover attribute)
    }
    public static String getYear(String id){
        //TODO: access Record by id (so Playlist or Song DAO) return their Cover attribute)
    }
}

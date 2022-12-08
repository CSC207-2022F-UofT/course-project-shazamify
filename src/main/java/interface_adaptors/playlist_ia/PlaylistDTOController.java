package interface_adaptors.playlist_ia;

import abr.PlaylistDTOUseCase;
import abr.SongDTOUseCase;

import java.awt.*;
import java.io.File;
import java.util.List;

public class PlaylistDTOController {
    public static String getName(String id){
        return PlaylistDTOUseCase.getName(id);
    }
    public static String getArtist(String id){
        return PlaylistDTOUseCase.getArtist(id);
    }
    public static File getCover(String id){
        return PlaylistDTOUseCase.getCover(id);
    }
    public static List<String> getSongs(String id){
        return PlaylistDTOUseCase.getSongs(id);
    }
    //public static String getYear(String id){ return PlaylistDTOUseCase.getYear(id); }
}

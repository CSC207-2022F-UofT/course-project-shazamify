package interface_adaptors;

import abr.PlaylistDTOUseCase;
import abr.SongDTOUseCase;

import java.awt.*;

public class PlaylistDTOController {
    public static String getName(String id){
        return PlaylistDTOUseCase.getName(id);
    }
    public static String getArtist(String id){
        return PlaylistDTOUseCase.getArtist(id);
    }
    public static Image getCover(String id){
        return PlaylistDTOUseCase.getCover(id);
    }
    public static String getYear(String id){ return PlaylistDTOUseCase.getYear(id); }
}

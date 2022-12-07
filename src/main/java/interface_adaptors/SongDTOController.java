package interface_adaptors;

import abr.SongDTOUseCase;

import java.awt.*;

public class SongDTOController {
    public static String getName(String id){
        return SongDTOUseCase.getName(id);
    }
    public static String getArtist(String id){
        return SongDTOUseCase.getArtist(id);
    }
    public static Image getCover(String id){
        return SongDTOUseCase.getCover(id);
    }
    public static String getYear(String id){ return SongDTOUseCase.getYear(id); }
}

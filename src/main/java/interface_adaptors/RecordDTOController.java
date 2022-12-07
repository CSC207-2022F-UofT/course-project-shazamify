package interface_adaptors;

import abr.RecordDTOUseCase;

import java.awt.*;

public class RecordDTOController {
    public static String getName(String id){
        return RecordDTOUseCase.getName(id);
    }
    public static String getArtist(String id){
        return RecordDTOUseCase.getArtist(id);
    }
    public static Image getCover(String id){
        return RecordDTOUseCase.getCover(id);
    }
    public static int getYear(String id){ return RecordDTOUseCase.getYear(id); }
}

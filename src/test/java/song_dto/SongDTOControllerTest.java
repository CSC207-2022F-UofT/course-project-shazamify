package song_dto;

import abr.SongDTOUseCase;
import abr.song_abr.SongDAOOutput;
import ds.song_ds.SongDAOOutputImpl;
import entities.Song;
import interface_adaptors.SongDTOController;
import org.junit.Test;

public class SongDTOControllerTest {

    @Test
    public void verifyFilePath() {

        System.out.println("One " + SongDTOController.getFilePath("FXovf5dsRTw"));
        System.out.println("Two " + SongDTOUseCase.getFilePath("FXovf5dsRTw"));

        SongDAOOutput songDAOOutput = new SongDAOOutputImpl();
        if(songDAOOutput.findById("FXovf5dsRTw").isPresent()) {
            Song s = songDAOOutput.findById("FXovf5dsRTw").get();
            Song s1 = songDAOOutput.findByName("Despacito").get();
            System.out.println("Three " + s.getFilePath());
            System.out.println("Four " + s.getFilePath());
            System.out.println("Five " + s1.getFilePath());
            System.out.println("Six " + s);
            System.out.println("Seven " + s.getFilePath());
            System.out.println("Eight " + s.getName() + s.getArtist() + s.getYear() + s.getId());
        } else {
            System.out.println("Song not present");
        }

    }

}

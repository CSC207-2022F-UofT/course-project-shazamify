package abr.song_abr;

import ds.song_ds.SongDAOOutputImpl;

import java.util.List;

/***
 * The QueueFDTO is a data transfer object responsible for carrying an updated list of song IDs from the queue and
 * the ID of the song that will be played in the song player immediately.
 */
public class SongDTO {
    private final String songID;
    private final String songFile;
    SongDAOOutput songDAOOutput = new SongDAOOutputImpl();

    public SongDTO(String songID) {
        String songFile1;
        this.songID = songID;

        songFile1 = null;
        // We assume that the song ID exists and there will be a file to store in the DTO
        if (songDAOOutput.findById(this.songID).isPresent()) {
            songFile1 = songDAOOutput.findById(this.songID).get().getFilePath();
        }
        this.songFile = songFile1;
    }
}

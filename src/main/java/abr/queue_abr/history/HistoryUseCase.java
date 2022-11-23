package abr.queue_abr.history;

import entities.Song;
import entities.queue_entities.HistoryQueue;
import ds.song_ds.*;

import java.util.*;

/***
 * The class responsible for updating the history queue with songs that have been listened to.
 */
public class HistoryUseCase {
    public void add(String id, double elapsed) {
        SongDAOOutput songDAOOutput = new SongDAOOutputImpl();
        Optional<Song> s = songDAOOutput.findById(id);
        Song song = new Song();
        double percentage = 0.0;

        // If the song exists (which it always should), find the percentage of listened time to song time
        if (s.isPresent()) {
            song = s.get();
        }
        percentage = elapsed / song.getDuration();

        // If you listened to the song longer than the song actually is (i.e. going back and listening again), return
        // the percentage as 1 only
        if (percentage > 1) {
            percentage = 1;
        }

        // Get the instance of the history queue.
        HistoryQueue historyQueue = HistoryQueue.getInstance();

        // Add the song ID and percentage (or override if it's not the first time listening)
        historyQueue.addSong(id, (float) percentage);
    }
}

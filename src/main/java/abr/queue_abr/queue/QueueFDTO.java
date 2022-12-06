package abr.queue_abr.queue;

import java.util.List;

/***
 * The QueueFDTO is a data transfer object responsible for carrying an updated list of song IDs from the queue and
 * the ID of the song that will be played in the song player immediately.
 */
public class QueueFDTO {
    public final List<String> songList;
    public final String songID;

    public QueueFDTO(List<String> songList, String songID) {
        this.songList = songList;
        this.songID = songID;
    }
}

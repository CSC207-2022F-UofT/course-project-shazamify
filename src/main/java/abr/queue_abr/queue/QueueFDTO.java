package abr.queue_abr.queue;

import java.util.List;

//TODO:javadoc
public class QueueFDTO {
    public final List<String> songList;
    public final String songID;

    public QueueFDTO(List<String> songList, String songID) {
        this.songList = songList;
        this.songID = songID;
    }
}

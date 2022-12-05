package abr.queue_abr.queue;

import java.util.List;

//TODO:javadoc
public class QueueGetDTO {
    public final List<String> songList;

    public QueueGetDTO(List<String> songList) {
        this.songList = songList;
    }
}

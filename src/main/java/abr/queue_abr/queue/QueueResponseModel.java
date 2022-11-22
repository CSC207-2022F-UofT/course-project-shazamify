package abr.queue_abr.queue;

import java.util.*;

/***
 * The queue response model is a list of the songs that has been updated and currently inside the queue.
 */
public class QueueResponseModel {
    private List<String> songList;

    public QueueResponseModel(){
    }

    public void setSongList(List<String> songList) {
        this.songList = songList;
    }

    public List<String> getSongList() {
        return songList;
    }
}

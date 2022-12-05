package abr.queue_abr.queue;

import java.util.*;

//TODO javadocs
/***
 * The queue response model is a list of the songs that has been updated and currently inside the queue.
 */
public class QueueGetResponseModel {
    private List<String> songList;

    public QueueGetResponseModel(){
    }

    public void setSongList(List<String> songList) {
        this.songList = songList;
    }

    public List<String> getSongList() {
        return songList;
    }
}

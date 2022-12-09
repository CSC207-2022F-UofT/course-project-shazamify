package abr.queue_abr.queue;

import java.util.List;

/***
 * The queue response model is data structure containing a list of song IDs inside the queue.
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

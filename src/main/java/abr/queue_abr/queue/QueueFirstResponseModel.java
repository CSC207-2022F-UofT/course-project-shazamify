package abr.queue_abr.queue;

import java.util.*;

/***
 * The queue response model is a list of the songs that has been updated and currently inside the queue.
 */
public class QueueFirstResponseModel {
    private List<String> songList;
    private String songID;

    public QueueFirstResponseModel(){
    }

    public void setSongList(List<String> songList) {
        this.songList = songList;
    }

    public void setSong(String songID) {
        this.songID = songID;
    }

    public List<String> getSongList() {
        return songList;
    }

    public String getSongID() {
        return songID;
    }
}

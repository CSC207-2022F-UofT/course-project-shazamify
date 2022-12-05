package abr.queue_abr.queue;

import java.util.*;

/***
 * The queue first response model is a list of the songs that has been updated and currently inside the queue.
 * It also contains the ID of a song that needs to be played immediately.
 */
public class QueueFRespM {
    private List<String> songList;
    private String songID;

    public QueueFRespM(){
    }

    public void setSongList(List<String> songList) {
        this.songList = songList;
    }

    public void setSongID(String songID) {
        this.songID = songID;
    }

    public List<String> getSongList() {
        return songList;
    }

    public String getSongID() {
        return songID;
    }
}

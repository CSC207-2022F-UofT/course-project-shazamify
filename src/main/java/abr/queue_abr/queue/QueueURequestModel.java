package abr.queue_abr.queue;

import java.util.*;

public class QueueURequestModel {
    private final List<String> songList;

    /***
     * A data structure containing a list of songs that the queue should be updated to.
     * @param songList - A list of song objects with desired changes made by the user.
     */
    public QueueURequestModel(List<String> songList) {
        this.songList = songList;
    }

    public List<String> getSongList() {
        return songList;
    }
}

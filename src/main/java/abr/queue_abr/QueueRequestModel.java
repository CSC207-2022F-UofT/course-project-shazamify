package abr.queue_abr;

import entities.Song;

import java.util.*;

public class QueueRequestModel {
    private final List<Song> songList;

    /***
     * A data structure containing a list of songs that the queue should be updated to.
     * @param songList - A list of song objects with desired changes made by the user.
     */
    public QueueRequestModel(List<Song> songList) {
        this.songList = songList;
    }

    public List<Song> getSongList() {
        return songList;
    }
}

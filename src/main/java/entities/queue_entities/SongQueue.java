package entities.queue_entities;

import java.util.*;

public class SongQueue {
    /***
     * Singleton class of the song queue. Creates an empty queue at the beginning of the program,
     * and can store a list of songs to be played in the order. The song list can be changed and returned.
     */
    private static SongQueue queue;
    private List<String> songList;

    // Creates the song queue with an empty list
    private SongQueue() {
        this.songList = new ArrayList<>();
    }

    public static SongQueue getInstance() {

        // Create if the song queue does not currently exist
        if (queue == null) {
            queue = new SongQueue();
        }

        return queue;
    }

    public void setQueue(List<String> queue) {
        this.songList = queue;
    }

    public List<String> getQueue() {
        return this.songList;
    }
}

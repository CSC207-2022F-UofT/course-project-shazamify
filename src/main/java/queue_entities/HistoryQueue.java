package queue_entities;

import entities.Song;

import java.util.*;

public class HistoryQueue {
    /***
     * Singleton class of the history queue. Creates an empty hashmap at the beginning of the program,
     * and can store a list of played songs and their respective listening time.
     * The hashmap can add key/values and be returned.
     */
    private static HistoryQueue historyQueue;
    private HashMap<Song, Float> songHashMap;

    // Creates history queue with an empty hashmap
    private HistoryQueue() {
        this.songHashMap = new HashMap<>();
    }

    public static HistoryQueue getInstance() {

        // Create if the history queue does not currently exist
        if (historyQueue == null) {
            historyQueue = new HistoryQueue();
        }

        return historyQueue;
    }

    public void addSong(Song song, float percentage) {
        this.songHashMap.put(song, percentage);
    }

    public HashMap<Song, Float> getSongHashMap() {
        return this.songHashMap;
    }
}

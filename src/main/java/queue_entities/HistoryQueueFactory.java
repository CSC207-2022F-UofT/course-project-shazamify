package queue_entities;

import entities.Song;

import java.util.*;

public class HistoryQueueFactory {
    /***
     * Produces a HistoryQueue object with an initial song hashmap.
     * @param songHashMap - A hashmap of songs that are recently played and the percentage of the song played.
     * @return - A new HistoryQueue object with the song hashmap.
     */
    public HistoryQueue create(HashMap<Song, Float> songHashMap) {
        return new HistoryQueue(songHashMap);
    }
}

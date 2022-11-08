package queue_entities;

import entities.Song;

import java.util.*;

public class HistoryQueueFactory {
    //TODO: Add javadocs
    public HistoryQueue create(HashMap<Song, Float> songHashMap) {
        return new HistoryQueue(songHashMap);
    }
}

package QueueEntities;

import Entities.Song;

import java.util.*;

public class HistoryQueueFactory {
    public HistoryQueue create(HashMap<Song, Float> songHashMap) {
        return new HistoryQueue(songHashMap);
    }
}

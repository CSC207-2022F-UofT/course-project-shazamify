package QueueEntities;

import Entities.Song;

import java.util.*;

public class SongQueueFactory {
    //TODO: Add javadocs
    public SongQueue create(List<Song> queue) {
        return new SongQueue(queue);
    }
}

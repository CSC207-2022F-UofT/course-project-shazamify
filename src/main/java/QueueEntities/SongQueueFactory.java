package QueueEntities;

import Entities.Song;

import java.util.*;

public class SongQueueFactory {
    public SongQueue create(List<Song> queue) {
        return new SongQueue(queue);
    }
}

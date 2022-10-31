package QueueEntities;

import Entities.Song;

import java.util.*;

public class SongQueue {
    private List<Song> queue;

    SongQueue(List<Song> queue) {
        this.queue = queue;
    }

    public void setQueue(List<Song> queue) {
        this.queue = queue;
    }

    public List<Song> getQueue() {
        return this.queue;
    }
}

package queue_entities;

import entities.Song;

import java.util.*;

public class SongQueue {
    //TODO: Add javadocs
    private List<Song> queue;

    public SongQueue(List<Song> queue) {
        this.queue = queue;
    }

    public void setQueue(List<Song> queue) {
        this.queue = queue;
    }

    public List<Song> getQueue() {
        return this.queue;
    }
}

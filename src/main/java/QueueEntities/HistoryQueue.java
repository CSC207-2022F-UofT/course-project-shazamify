package QueueEntities;

import Entities.Song;

import java.util.*;

public class HistoryQueue {
    HashMap<Song, Float> songHashMap;

    HistoryQueue(HashMap<Song, Float> songHashMap) {
        this.songHashMap = songHashMap;
    }

    public void addSong(Song song, float percentage) {
        this.songHashMap.put(song, percentage);
    }

    public HashMap<Song, Float> getSongHashMap() {
        return this.songHashMap;
    }
}

package abr.queue_abr;

import entities.Song;

import java.util.*;

/***
 * The queue response model is a list of the songs that has been updated and currently inside the queue.
 */
public class QueueResponseModel {
    private List<Song> songList;

    public QueueResponseModel(){
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public List<Song> getSongList() {
        return songList;
    }
}

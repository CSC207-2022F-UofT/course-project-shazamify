package interface_adaptors.queue_screen;

import entities.Song;

import java.util.List;

//TODO: add javadocs
public class QueueViewModel {
    private List<Song> songList;

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public List<Song> getSongList() {
        return songList;
    }
}

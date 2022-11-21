package interface_adaptors.queue_ia;

import java.util.List;

//TODO: add javadocs
public class QueueViewModel {
    private List<String> songList;

    public void setSongList(List<String> songList) {
        this.songList = songList;
    }

    public List<String> getSongList() {
        return songList;
    }
}

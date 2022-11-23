package interface_adaptors.queue_ia;

import java.util.List;

/***
 * The queue view model is responsible for taking in the packaged data structure from the view model and displaying
 * the queue (as a list of songs) on the UI
 */
public class QueueViewModel {
    private List<String> songList;

    public void setSongList(List<String> songList) {
        this.songList = songList;
    }

    public List<String> getSongList() {
        return songList;
    }
}

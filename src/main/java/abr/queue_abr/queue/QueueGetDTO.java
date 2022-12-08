package abr.queue_abr.queue;

import java.util.List;

/***
 * A data transfer object of the list of songs with only one attribute. This was made in order to avoid primitive
 * obsession. It also allows for more clarity on what is being transferred.
 */
public class QueueGetDTO {
    public final List<String> songList;

    public QueueGetDTO(List<String> songList) {
        this.songList = songList;
    }
}

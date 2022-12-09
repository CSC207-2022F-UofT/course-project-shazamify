package abr.queue_abr.queue;

import entities.queue_entities.SongQueue;

import java.util.List;

public class QueueFHelper {

    /***
     * The helper class responsible for removing the first song ID in the queue's list of song IDs. After removing the
     * first song ID from the queue's list of song IDs, it stores the new list for future use.
     * @return A new data transfer object containing the new list of song IDs (generated from removing the first song ID
     * from the old queue), along with the song ID of the removed song.
     */
    public QueueFDTO next() {

        // songQueue is the queue object that contains the current queue list
        SongQueue songQueue = SongQueue.getInstance();

        // Gets the current list of songs in the queue
        List<String> songList = songQueue.getQueue();

        // Remove the first song
        String firstSongID = songList.get(0);
        songList.remove(firstSongID);

        // Sets the new queue (removed the first song)
        songQueue.setQueue(songList);

        return new QueueFDTO(songList, firstSongID);
    }
}

package abr.queue_abr.queue;

import entities.queue_entities.SongQueue;

import java.util.*;

public class QueueGetHelper {

    /***
     * The helper class responsible for retrieving a list of songs from the singleton queue object.
     * @return The data transfer object containing the queue's current list of song IDs.
     */
    public QueueGetDTO get() {

        // songQueue is the queue object that contains the current queue list
        SongQueue songQueue = SongQueue.getInstance();

        // Get the list of song IDs from the queue
        List<String> songList = songQueue.getQueue();

        return new QueueGetDTO(songList);
    }
}

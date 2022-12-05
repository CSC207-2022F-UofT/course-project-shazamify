package abr.queue_abr.queue;

import entities.queue_entities.SongQueue;

import java.util.*;

//TODO javadoc
public class QueueUHelper {

    /***
     * The helper class responsible for dealing with comparing the two lists. Updates the current queue object to
     * contain the requested song list.
     * @param uRequestModel - A data structure containing the desired queue list.
     */
    public void update(QueueURequestModel uRequestModel) {

        // songList is a full list of the song order that is to be desired.
        // songQueue is the queue object that contains the current queue list
        List<String> songList = uRequestModel.getSongList();
        SongQueue songQueue = SongQueue.getInstance();

        // Sets the queue to contain the new list, and updates the response model with that same new list to be returned
        songQueue.setQueue(songList);
    }
}
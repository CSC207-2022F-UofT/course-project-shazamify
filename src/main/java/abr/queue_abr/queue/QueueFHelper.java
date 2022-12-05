package abr.queue_abr.queue;

import entities.queue_entities.SongQueue;

import java.util.*;

//TODO: update javadocs
public class QueueFHelper {

    /***
     * The helper class responsible for dealing with comparing the two lists. Updates the current queue object to
     * contain the requested song list.
     * @param fReqM - A data structure containing the desired queue list.
     * @param fRespM - A data structure containing the new and updated queue list.
     * @return The response model described on the response model parameter.
     */
    public QueueFDTO next(QueueFReqM fReqM, QueueFRespM fRespM) {

        // songQueue is the queue object that contains the current queue list
        SongQueue songQueue = SongQueue.getInstance();

        // Sets the queue to contain the new list, and updates the response model with that same new list to be returned
        List<String> songList = songQueue.getQueue();

        String firstSongID = songList.get(0);
        songList.remove(firstSongID);

        // Sets the new queue (removed the first song)
        songQueue.setQueue(songList);

        QueueFDTO queueFDTO = new QueueFDTO(songList, firstSongID);

        return queueFDTO;
    }
}

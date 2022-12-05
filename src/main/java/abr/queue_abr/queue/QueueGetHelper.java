package abr.queue_abr.queue;

import entities.queue_entities.SongQueue;

import java.util.*;

//TODO: update javadocs
public class QueueGetHelper {

    /***
     * The helper class responsible for dealing with comparing the two lists. Updates the current queue object to
     * contain the requested song list.
     * @param getRequestModel - A data structure containing the desired queue list.
     * @param getResponseModel - A data structure containing the new and updated queue list.
     * @return The response model described on the response model parameter.
     */
    public QueueGetDTO get(QueueGetRequestModel getRequestModel, QueueGetResponseModel getResponseModel) {

        // songQueue is the queue object that contains the current queue list
        SongQueue songQueue = SongQueue.getInstance();

        // Sets the queue to contain the new list, and updates the response model with that same new list to be returned
        List<String> songList = songQueue.getQueue();

        QueueGetDTO queueGetDTO = new QueueGetDTO(songList);

        return queueGetDTO;
    }
}

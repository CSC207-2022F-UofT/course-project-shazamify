package abr.queue_abr.queue;

import entities.queue_entities.SongQueue;

import java.util.*;

public class QueueHelper {

    /***
     * The helper class responsible for dealing with comparing the two lists. Updates the current queue object to
     * contain the requested song list.
     * @param requestModel - A data structure containing the desired queue list.
     * @param responseModel - A data structure containing the new and updated queue list.
     * @return The response model described on the response model parameter.
     */
    public QueueResponseModel update(QueueRequestModel requestModel, QueueResponseModel responseModel) {

        // songList is a full list of the song order that is to be desired.
        // songQueue is the queue object that contains the current queue list
        List<String> songList = requestModel.getSongList();
        SongQueue songQueue = SongQueue.getInstance();

        // Sets the queue to contain the new list, and updates the response model with that same new list to be returned
        songQueue.setQueue(songList);
        responseModel.setSongList(songQueue.getQueue());

        return responseModel;
    }
}

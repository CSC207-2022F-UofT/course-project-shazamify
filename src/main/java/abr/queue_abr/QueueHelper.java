package abr.queue_abr;

import entities.Song;
import entities.queue_entities.HistoryQueue;
import entities.queue_entities.SongQueue;

import java.util.*;

public class QueueHelper {

    /***
     * The helper class responsible for dealing with comparing the two lists. If the new list is missing songs from the
     * current queue list, that means that either the song was finished playing or removed. In either scenario, we add
     * the removed song to the history queue with it's elapsed play time.
     * @param requestModel - A data structure containing the desired queue list.
     * @param responseModel - A data structure containing the new and updated queue list.
     * @return The response model described on the response model parameter.
     */
    //TODO: update javadocs when complete
    public QueueResponseModel update(QueueRequestModel requestModel, QueueResponseModel responseModel) {

        // songList is a full list of the song order that is to be desired.
        // songQueue is the queue object that contains the current queue list
        // queueList is the current queue list.
        // historyQueue is the hashmap object that stores removed songs from the queue and their playtime.
        List<Song> songList = requestModel.getSongList();
        SongQueue songQueue = SongQueue.getInstance();
        List<Song> queueList = songQueue.getQueue();
        HistoryQueue historyQueue = HistoryQueue.getInstance();

        for (Song song : queueList) {
            // If the current queue list does not contain a song in the desired song list, add it to the history queue.
            if (!songList.contains(song)) {
                //TODO: Remember to change default percentage as the persistence model is still ambiguous
               historyQueue.addSong(song, 0);
            }
        }

        // Sets the queue to contain the new list, and updates the response model with that same new list to be returned
        songQueue.setQueue(songList);
        responseModel.setSongList(songList);

        return responseModel;
    }
}

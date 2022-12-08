package abr.queue_abr.queue;

/***
 * Queue first input boundary is implemented by the use case for first song and contains the method get the first song
 * in the queue.
 * Draws the connection between the queue first controller and the use case for first song.
 */
public interface QueueFIB {
    void getFirst(QueueFReqM firstRequestModel);
}

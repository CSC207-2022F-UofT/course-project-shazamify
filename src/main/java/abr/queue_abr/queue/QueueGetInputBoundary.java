package abr.queue_abr.queue;

//TODO javadocs
/***
 * Queue input boundary is implemented by the use case and contains the method to update the song queue.
 * Draws the connection between the queue controller and the use case
 */
public interface QueueGetInputBoundary {
    void get(QueueGetRequestModel getRequestModel);
}

package abr.queue_abr.queue;

/***
 * Queue get input boundary is implemented by the use case and contains the method to retrieve the queue's list of song
 * IDs. Draws the connection between the queue controller and the use case
 */
public interface QueueGetInputBoundary {
    void get(QueueGetRequestModel getRequestModel);
}

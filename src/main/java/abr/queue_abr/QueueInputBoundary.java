package abr.queue_abr;

import queue_screen.QueueViewModel;

/***
 * Queue input boundary is implemented by the use case and contains the method to update the song queue (or history
 * queue if applicable)
 */
//TODO: Update javadoc after done
public interface QueueInputBoundary {
    QueueViewModel update(QueueRequestModel requestModel);
}

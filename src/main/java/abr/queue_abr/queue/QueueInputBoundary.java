package abr.queue_abr.queue;

import interface_adaptors.queue_ia.QueueViewModel;

/***
 * Queue input boundary is implemented by the use case and contains the method to update the song queue.
 */
public interface QueueInputBoundary {
    QueueViewModel update(QueueRequestModel requestModel);
}

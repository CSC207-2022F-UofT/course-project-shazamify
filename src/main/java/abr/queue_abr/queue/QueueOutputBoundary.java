package abr.queue_abr.queue;

import interface_adaptors.queue_ia.QueueViewModel;

/***
 * Queue output boundary is implemented by the presenter and contains the method to present the new queue list.
 */
public interface QueueOutputBoundary {
    QueueViewModel present(QueueResponseModel responseModel);
}

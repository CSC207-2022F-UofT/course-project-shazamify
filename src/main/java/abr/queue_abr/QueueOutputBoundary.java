package abr.queue_abr;

import interface_adaptors.queue_screen.QueueViewModel;

/***
 * Queue output boundary is implemented by the presenter and contains the method to present the new queue list.
 */
public interface QueueOutputBoundary {
    QueueViewModel present(QueueResponseModel responseModel);
}

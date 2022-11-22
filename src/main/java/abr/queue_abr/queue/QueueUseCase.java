package abr.queue_abr.queue;

import interface_adaptors.queue_ia.QueueViewModel;

/***
 * The queue use case contains a facade class which determines what the new queue should be. It returns an updated
 * response model containing the new and updated queue list.
 */
public class QueueUseCase implements QueueInputBoundary{

    private final QueueHelper queueHelper = new QueueHelper();
    private final QueueOutputBoundary outputBoundary;

    public QueueUseCase(QueueOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /***
     * Returns a view model with the updated queue determined by the requested queue list.
     * @param requestModel - The list of songs that the new queue should be
     * @return - The new queue with the desired songs.
     */
    @Override
    public QueueViewModel update(QueueRequestModel requestModel) {
        QueueResponseModel responseModel = new QueueResponseModel();
        QueueResponseModel updatedResponseModel = queueHelper.update(requestModel, responseModel);

        return outputBoundary.present(updatedResponseModel);
    }
}

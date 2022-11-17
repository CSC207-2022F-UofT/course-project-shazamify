package abr.queue_abr;

import queue_screen.QueueViewModel;

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

    @Override
    public QueueViewModel update(QueueRequestModel requestModel) {
        QueueResponseModel responseModel = new QueueResponseModel();
        QueueResponseModel updatedResponseModel = queueHelper.update(requestModel, responseModel);

        //TODO: Double check to make sure two use cases are not needed (one for adding and deleting)
        return outputBoundary.present(updatedResponseModel);
    }
}

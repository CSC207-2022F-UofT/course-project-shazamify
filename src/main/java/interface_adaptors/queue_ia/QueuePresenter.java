package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueOutputBoundary;
import abr.queue_abr.queue.QueueResponseModel;

/***
 * The queue presenter is responsible for taking the response model list of songs and packiging it for the view model.
 */
public class QueuePresenter implements QueueOutputBoundary {
    @Override
    public QueueViewModel present(QueueResponseModel responseModel) {
        QueueViewModel viewModel = new QueueViewModel();

        viewModel.setSongList(responseModel.getSongList());

        return viewModel;
    }
}

package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueOutputBoundary;
import abr.queue_abr.queue.QueueResponseModel;

/***
 * The queue presenter is responsible for taking the response model list of songs and packaging it for the view model.
 */
public class QueuePresenter implements QueueOutputBoundary {

    QueueViewModel viewModel;

    public QueuePresenter(QueueViewModel queueViewModel) {
        this.viewModel = queueViewModel;
    }
    @Override
    public void present(QueueResponseModel responseModel) {
        viewModel.setSongList(responseModel.getSongList());
    }
}

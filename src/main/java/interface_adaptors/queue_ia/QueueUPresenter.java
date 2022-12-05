package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueUOutputBoundary;
import abr.queue_abr.queue.QueueUResponseModel;

/***
 * The queue presenter is responsible for taking the response model list of songs and packaging it for the view model.
 */
public class QueueUPresenter implements QueueUOutputBoundary {

    QueueViewModel viewModel;

    public QueueUPresenter(QueueViewModel queueViewModel) {
        this.viewModel = queueViewModel;
    }
    @Override
    public void present(QueueUResponseModel responseModel) {
        viewModel.setSongList(responseModel.getSongList());
    }
}

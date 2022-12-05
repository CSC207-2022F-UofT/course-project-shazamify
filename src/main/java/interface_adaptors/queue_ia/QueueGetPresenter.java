package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueGetOutputBoundary;
import abr.queue_abr.queue.QueueGetResponseModel;

//TODO javadocs
/***
 * The queue presenter is responsible for taking the response model list of songs and packaging it for the view model.
 */
public class QueueGetPresenter implements QueueGetOutputBoundary {

    QueueViewModel viewModel;

    public QueueGetPresenter(QueueViewModel queueViewModel) {
        this.viewModel = queueViewModel;
    }
    @Override
    public void present(QueueGetResponseModel getResponseModel) {
        viewModel.setSong_ids(getResponseModel.getSongList());
    }
}
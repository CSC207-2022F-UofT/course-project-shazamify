package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueGetOutputBoundary;
import abr.queue_abr.queue.QueueGetResponseModel;

/***
 * The queue presenter is responsible for taking the response model list of songs and packaging it for the view model.
 */
public class QueueGetPresenter implements QueueGetOutputBoundary {

    private final QueueViewModel viewModel = QueueViewModel.getInstance();

    @Override
    public void present(QueueGetResponseModel getResponseModel) {
        viewModel.setSong_ids(getResponseModel.getSongList());
    }
}
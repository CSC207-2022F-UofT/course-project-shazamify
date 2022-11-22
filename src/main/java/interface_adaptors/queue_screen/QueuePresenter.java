package interface_adaptors.queue_screen;

import abr.queue_abr.QueueOutputBoundary;
import abr.queue_abr.QueueResponseModel;

// Add javadocs
public class QueuePresenter implements QueueOutputBoundary {

    @Override
    public QueueViewModel present(QueueResponseModel responseModel) {
        QueueViewModel viewModel = new QueueViewModel();

        viewModel.setSongList(responseModel.getSongList());

        return viewModel;
    }
}

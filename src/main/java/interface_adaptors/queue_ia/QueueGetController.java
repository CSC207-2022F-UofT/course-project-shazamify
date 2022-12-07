package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueGetInputBoundary;
import abr.queue_abr.queue.QueueGetRequestModel;

/***
 * The Queue get controller is responsible for making the call to update the view model with the current list of songs
 * in the queue
 */
public class QueueGetController {
    QueueGetInputBoundary getInputBoundary;

    public QueueGetController(QueueGetInputBoundary getInputBoundary) {
        this.getInputBoundary = getInputBoundary;
    }

    public void retrieveList() {
        QueueGetRequestModel getRequestModel = new QueueGetRequestModel();

        getInputBoundary.get(getRequestModel);
    }
}

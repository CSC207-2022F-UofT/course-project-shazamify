package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueGetInputBoundary;
import abr.queue_abr.queue.QueueGetRequestModel;

//TODO javadocs
/***
 * The Queue controller is responsible for passing down the song list of IDs from the UI level to the use case.
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

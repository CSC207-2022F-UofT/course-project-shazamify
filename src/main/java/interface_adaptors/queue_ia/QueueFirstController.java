package interface_adaptors.queue_ia;


import abr.queue_abr.queue.QueueFIB;
import abr.queue_abr.queue.QueueFReqM;

/***
 * The Queue controller is responsible for passing down the song list of IDs from the UI level to the use case.
 */
public class QueueFirstController {
    QueueFIB firstInputBoundary;

    public QueueFirstController(QueueFIB firstInputBoundary) {
        this.firstInputBoundary = firstInputBoundary;
    }

    public void retrieve() {
        QueueFReqM firstRequestModel = new QueueFReqM();

        firstInputBoundary.getFirst(firstRequestModel);
    }
}

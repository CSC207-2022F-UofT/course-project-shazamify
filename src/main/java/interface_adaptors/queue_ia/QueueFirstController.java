package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueFIB;
import abr.queue_abr.queue.QueueFReqM;

/***
 * The Queue controller is responsible for retrieving the first song in the queue's list and removing that song
 * from the queue's song list.
 */
public class QueueFirstController {
    QueueFIB firstInputBoundary;

    public QueueFirstController(QueueFIB firstInputBoundary) {
        this.firstInputBoundary = firstInputBoundary;
    }

    /***
     * Calls on the method inside the input boundary which is implemented by the use case.
     */
    public void retrieveFirst() {
        QueueFReqM firstRequestModel = new QueueFReqM();

        firstInputBoundary.getFirst(firstRequestModel);
    }
}

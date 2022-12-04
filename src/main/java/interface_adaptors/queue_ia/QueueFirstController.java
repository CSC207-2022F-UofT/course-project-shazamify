package interface_adaptors.queue_ia;


import java.util.*;

/***
 * The Queue controller is responsible for passing down the song list of IDs from the UI level to the use case.
 */
public class QueueFirstController {
    QueueFirstInputBoundary firstInputBoundary;

    public QueueFirstController(QueueFirstInputBoundary firstInputBoundary) {
        this.firstInputBoundary = firstInputBoundary;
    }

    public void retrieve() {
        QueueFirstRequestModel firstRequestModel = new QueueFirstRequestModel();

        firstInputBoundary.get(firstRequestModel);
    }
}

package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueUInputBoundary;
import abr.queue_abr.queue.QueueURequestModel;

import java.util.*;

/***
 * The Queue controller is responsible for passing down the song list of IDs from the UI level to the use case.
 */
public class QueueUController {
    QueueUInputBoundary inputBoundary;

    public QueueUController(QueueUInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void send(List<String> songList) {
        QueueURequestModel requestModel = new QueueURequestModel(songList);

        inputBoundary.update(requestModel);
    }
}

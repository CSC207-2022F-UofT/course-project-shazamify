package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueInputBoundary;
import abr.queue_abr.queue.QueueRequestModel;

import java.util.*;

/***
 * The Queue controller is responsible for passing down the song list of IDs from the UI level to the use case.
 */
public class QueueController {
    QueueInputBoundary inputBoundary;

    public QueueController(QueueInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void send(List<String> songList) {
        QueueRequestModel requestModel = new QueueRequestModel(songList);

        inputBoundary.update(requestModel);
    }
}

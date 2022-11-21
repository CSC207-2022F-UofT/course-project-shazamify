package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueInputBoundary;
import abr.queue_abr.queue.QueueRequestModel;

import java.util.*;

//TODO: Add javadocs
public class QueueController {
    QueueInputBoundary inputBoundary;

    public QueueController(QueueInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public QueueViewModel update(List<String> songList) {
        QueueRequestModel requestModel = new QueueRequestModel(songList);

        return inputBoundary.update(requestModel);
    }
}

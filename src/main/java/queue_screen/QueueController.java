package queue_screen;

import entities.Song;
import queue_abr.QueueInputBoundary;
import queue_abr.QueueRequestModel;

import java.util.*;

//TODO: Add javadocs
public class QueueController {
    QueueInputBoundary inputBoundary;

    public QueueController(QueueInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public QueueViewModel update(List<Song> songList) {
        QueueRequestModel requestModel = new QueueRequestModel(songList);

        return inputBoundary.update(requestModel);
    }
}

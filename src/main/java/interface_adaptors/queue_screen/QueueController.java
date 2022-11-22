package interface_adaptors.queue_screen;

import entities.Song;
import abr.queue_abr.QueueInputBoundary;
import abr.queue_abr.QueueRequestModel;

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

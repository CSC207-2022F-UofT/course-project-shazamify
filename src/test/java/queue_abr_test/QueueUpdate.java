package queue_abr_test;

import abr.queue_abr.queue.QueueInputBoundary;
import abr.queue_abr.queue.QueueOutputBoundary;
import abr.queue_abr.queue.QueueUseCase;
import interface_adaptors.queue_ia.QueueController;
import interface_adaptors.queue_ia.QueuePresenter;
import interface_adaptors.queue_ia.QueueViewModel;

import java.util.List;

public class QueueUpdate {

    public static void updateQueue(List<String> stringList, QueueViewModel queueViewModel) {
        QueueController queueController = initializeControllerTest(queueViewModel);
        queueController.send(stringList);
    }

    private static QueueController initializeControllerTest(QueueViewModel queueViewModel) {
        QueueOutputBoundary queuePresenter = new QueuePresenter(queueViewModel);
        QueueInputBoundary queueInputBoundary = new QueueUseCase(queuePresenter);

        return new QueueController(queueInputBoundary);
    }
}

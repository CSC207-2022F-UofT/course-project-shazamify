package queue_abr_test;

import abr.queue_abr.queue.QueueUInputBoundary;
import abr.queue_abr.queue.QueueUOutputBoundary;
import abr.queue_abr.queue.QueueUUseCase;
import interface_adaptors.queue_ia.QueueUController;
import interface_adaptors.queue_ia.QueueUPresenter;
import interface_adaptors.queue_ia.QueueViewModel;

import java.util.List;

public class QueueUpdate {

    public static void updateQueue(List<String> stringList, QueueViewModel queueViewModel) {
        QueueUController queueUController = initializeControllerTest(queueViewModel);
        queueUController.send(stringList);
    }

    private static QueueUController initializeControllerTest(QueueViewModel queueViewModel) {
        QueueUOutputBoundary queuePresenter = new QueueUPresenter(queueViewModel);
        QueueUInputBoundary queueInputBoundary = new QueueUUseCase(queuePresenter);

        return new QueueUController(queueInputBoundary);
    }
}

package framework.queue_screen;

import abr.queue_abr.queue.QueueUInputBoundary;
import abr.queue_abr.queue.QueueUOutputBoundary;
import abr.queue_abr.queue.QueueUUseCase;
import interface_adaptors.queue_ia.QueueUController;
import interface_adaptors.queue_ia.QueueUPresenter;
import interface_adaptors.queue_ia.QueueViewModel;

import javax.swing.*;

public class QueueManagerUI {

    final JFrame queueFrame = new JFrame();
    QueueUController controller;
    public QueueManagerUI(QueueUController controller) {
        this.controller = controller;

    }
    public static void main(String [] args) {
        QueueViewModel queueViewModel = new QueueViewModel();
        QueueUOutputBoundary presenter = new QueueUPresenter(queueViewModel);
        QueueUInputBoundary useCase = new QueueUUseCase(presenter);
        QueueUController controller = new QueueUController(useCase);

        QueueManagerUI queueManagerUI = new QueueManagerUI(controller);
    }
}

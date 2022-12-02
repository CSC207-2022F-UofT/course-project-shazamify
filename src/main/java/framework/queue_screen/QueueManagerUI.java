package framework.queue_screen;

import abr.queue_abr.queue.QueueInputBoundary;
import abr.queue_abr.queue.QueueOutputBoundary;
import abr.queue_abr.queue.QueueUseCase;
import interface_adaptors.queue_ia.QueueController;
import interface_adaptors.queue_ia.QueuePresenter;
import interface_adaptors.queue_ia.QueueViewModel;

import javax.swing.*;

public class QueueManagerUI {

    final JFrame queueFrame = new JFrame();
    QueueController controller;
    public QueueManagerUI(QueueController controller) {
        this.controller = controller;

    }
    public static void main(String [] args) {
        QueueViewModel queueViewModel = new QueueViewModel();
        QueueOutputBoundary presenter = new QueuePresenter(queueViewModel);
        QueueInputBoundary useCase = new QueueUseCase(presenter);
        QueueController controller = new QueueController(useCase);

        QueueManagerUI queueManagerUI = new QueueManagerUI(controller);
    }
}

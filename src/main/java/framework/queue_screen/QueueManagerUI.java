package framework.queue_screen;

import abr.queue_abr.queue.QueueInputBoundary;
import abr.queue_abr.queue.QueueOutputBoundary;
import abr.queue_abr.queue.QueueUseCase;
import interface_adaptors.queue_ia.QueueController;
import interface_adaptors.queue_ia.QueuePresenter;

import javax.swing.*;

//TODO: lmao
public class QueueManagerUI {

    final JFrame queueFrame = new JFrame();
    QueueController controller;
    public QueueManagerUI(QueueController controller) {
        this.controller = controller;

    }
    public static void main(String [] args) {

        QueueOutputBoundary presenter = new QueuePresenter();
        QueueInputBoundary useCase = new QueueUseCase(presenter);
        QueueController controller = new QueueController(useCase);

        QueueManagerUI queueManagerUI = new QueueManagerUI(controller);
    }
}

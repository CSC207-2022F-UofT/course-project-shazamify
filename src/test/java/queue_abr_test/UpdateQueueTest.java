package queue_abr_test;

import abr.queue_abr.queue.QueueUInputBoundary;
import abr.queue_abr.queue.QueueUUseCase;
import entities.queue_entities.*;
import interface_adaptors.queue_ia.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class UpdateQueueTest {
    @Test
    public void reorderQueue() {
        // Initialize the song queue object and create the input data
        SongQueue songQueue = SongQueue.getInstance();
        List<String> ids = Arrays.asList("1", "2", "3", "4", "5");
        songQueue.setQueue(ids);

        QueueUInputBoundary inputBoundary = new QueueUUseCase();
        QueueUController controller = new QueueUController(inputBoundary);
        controller.send(Arrays.asList("5", "4", "3", "2", "1"));

        assertEquals(songQueue.getQueue(), Arrays.asList("5", "4", "3", "2", "1"));
    }

    @Test
    public void addQueue() {
        SongQueue songQueue = SongQueue.getInstance();
        List<String> ids = Arrays.asList("1", "2", "3", "4");

        songQueue.setQueue(ids);

        QueueUInputBoundary inputBoundary = new QueueUUseCase();
        QueueUController controller = new QueueUController(inputBoundary);
        controller.send(Arrays.asList("1", "2", "3", "4", "5"));

        assertEquals(songQueue.getQueue(), Arrays.asList("1", "2", "3", "4", "5"));
    }

    @Test
    public void removeQueue() {
        SongQueue songQueue = SongQueue.getInstance();
        List<String> ids = Arrays.asList("1", "2", "3", "4", "5");

        songQueue.setQueue(ids);

        QueueUInputBoundary inputBoundary = new QueueUUseCase();
        QueueUController controller = new QueueUController(inputBoundary);
        controller.send(List.of("1"));

        assertEquals(songQueue.getQueue(), List.of("1"));
    }
}

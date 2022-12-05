package queue_abr_test;

import abr.queue_abr.queue.*;
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

        QueueViewModel queueViewModel = new QueueViewModel();
        queueViewModel.setSongList(songQueue.getQueue());
        QueueUpdate.updateQueue(Arrays.asList("5", "4", "3", "2", "1"), queueViewModel);

        assertEquals(songQueue.getQueue(), Arrays.asList("5", "4", "3", "2", "1"));
    }

    @Test
    public void addQueue() {
        SongQueue songQueue = SongQueue.getInstance();
        List<String> ids = Arrays.asList("1", "2", "3", "4");

        songQueue.setQueue(ids);

        QueueViewModel queueViewModel = new QueueViewModel();
        queueViewModel.setSongList(songQueue.getQueue());
        QueueUpdate.updateQueue(Arrays.asList("1", "2", "3", "4", "5"), queueViewModel);

        assertEquals(songQueue.getQueue(), Arrays.asList("1", "2", "3", "4", "5"));
    }

    @Test
    public void removeQueue() {
        SongQueue songQueue = SongQueue.getInstance();
        List<String> ids = Arrays.asList("1", "2", "3", "4", "5");

        songQueue.setQueue(ids);

        QueueViewModel queueViewModel = new QueueViewModel();
        queueViewModel.setSongList(songQueue.getQueue());
        QueueUpdate.updateQueue(List.of("1"), queueViewModel);

        assertEquals(songQueue.getQueue(), List.of("1"));
    }
}

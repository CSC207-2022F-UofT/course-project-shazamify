package queue_abr_test;

import abr.queue_abr.queue.*;
import entities.queue_entities.*;
import interface_adaptors.queue_ia.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class GetQueueTest {
    @Test
    public void getQueue() {
        // Initialize the song queue object and create the input data
        SongQueue songQueue = SongQueue.getInstance();
        List<String> ids = Arrays.asList("1", "2", "3", "4", "5");
        songQueue.setQueue(ids);

        QueueGetOutputBoundary getOutputBoundary = new QueueGetPresenter();
        QueueGetInputBoundary getInputBoundary = new QueueGetUseCase(getOutputBoundary);
        QueueGetController getController = new QueueGetController(getInputBoundary);
        getController.retrieveList();

        assertEquals(songQueue.getQueue(), QueueViewModel.getInstance().getSong_ids());
    }
}

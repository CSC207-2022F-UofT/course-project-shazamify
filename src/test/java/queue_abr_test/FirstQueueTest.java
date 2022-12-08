package queue_abr_test;

import abr.queue_abr.queue.*;
import entities.queue_entities.*;
import interface_adaptors.display_ia.SongPlayerAudio;
import interface_adaptors.queue_ia.*;
import interface_adaptors.song_player_ia.SongPlayerViewModel;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class FirstQueueTest {
    @Test
    public void retrieveFirst() {
        // Initialize the song queue object and create the input data
        SongQueue songQueue = SongQueue.getInstance();
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");
        songQueue.setQueue(ids);

        QueueFOB fob = new QueueFirstPresenter();
        QueueFIB fib = new QueueFUC(fob);
        QueueFirstController firstController = new QueueFirstController(fib);
        firstController.retrieveFirst();

        assertEquals(songQueue.getQueue(), QueueViewModel.getInstance().getSong_ids());
    }
}

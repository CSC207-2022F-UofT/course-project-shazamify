package queue_abr_test;

import abr.queue_abr.queue.QueueFIB;
import abr.queue_abr.queue.QueueFOB;
import abr.queue_abr.queue.QueueFUC;
import abr.song_abr.SongDAOInput;
import ds.song_ds.SongDAOInputImpl;
import entities.Song;
import entities.queue_entities.SongQueue;
import interface_adaptors.queue_ia.QueueFirstController;
import interface_adaptors.queue_ia.QueueFirstPresenter;
import interface_adaptors.queue_ia.QueueViewModel;
import interface_adaptors.song_player_ia.SongPlayerViewModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FirstQueueTest {
    @Test
    public void retrieveFirst() {
        // Initialize the song queue object and create the input data
        SongPlayerViewModel songPlayerViewModel = SongPlayerViewModel.getInstance();
        songPlayerViewModel.getView(2, 3);


        SongQueue songQueue = SongQueue.getInstance();
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");
        songQueue.setQueue(ids);

        SongDAOInput songDAOInput = new SongDAOInputImpl();
        Song s1 = new Song("Song1", "1", 1);
        Song s2 = new Song("Song2", "2", 2);
        Song s3 = new Song("Song3", "3", 3);

        try {
            songDAOInput.save(s1);
            songDAOInput.save(s2);
            songDAOInput.save(s3);

            QueueFOB fob = new QueueFirstPresenter();
            QueueFIB fib = new QueueFUC(fob);
            QueueFirstController firstController = new QueueFirstController(fib);
            firstController.retrieveFirst();

            assertEquals(songQueue.getQueue(), QueueViewModel.getInstance().getSong_ids());
        } finally {
            songDAOInput.delete(s1);
            songDAOInput.delete(s2);
            songDAOInput.delete(s3);
        }

    }
}

package interface_adaptors.queue_ia;

import abr.queue_abr.queue.QueueFOB;
import abr.queue_abr.queue.QueueFRespM;
import interface_adaptors.display_ia.SongPlayerAudio;

/***
 * The queue presenter is responsible for taking the response model's list of songs and song ID and updating the view
 * model of the queue and song player with the song list and song ID.
 */
public class QueueFirstPresenter implements QueueFOB {

    private final QueueViewModel viewModel = QueueViewModel.getInstance();
    private final SongPlayerAudio songPlayerAudio = SongPlayerAudio.getInstance();

    @Override
    public void present(QueueFRespM fRespM) {
        songPlayerAudio.displaySongPlayer(fRespM.getSongID());
        viewModel.setSong_ids(fRespM.getSongList());
    }
}
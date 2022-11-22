package interface_adaptors;

import entities.playlist_entities.Playlist;
import screen.RecordViewModel;

import java.io.File;
import java.util.ArrayList;

public class DisplayRecordUseCase extends AbstractDisplayUseCase {

    private static DisplayRecordUseCase instance;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static DisplayRecordUseCase getInstance() {
        if (instance == null) {instance = new DisplayRecordUseCase();}
        return instance;
    }

    public void displayPlaylist(Playlist playlist) {
        try {
            // Fetch songs from database
            //Playlist playlist = fetchPlaylist();
            // Send to ViewModel
            RecordViewModel.getInstance().updateView(playlist);
        }
        catch ( Exception e ) {
            System.out.println(e.getStackTrace());
        }
    }
/*
    private ArrayList<Song> fetchSongs() {

    }

 */

}

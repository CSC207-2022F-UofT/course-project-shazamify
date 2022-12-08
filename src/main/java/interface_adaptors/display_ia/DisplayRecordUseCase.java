package interface_adaptors.display_ia;

import entities.playlist_entities.Playlist;
import interface_adaptors.playlist_ia.RecordViewModel;

public class DisplayRecordUseCase {

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

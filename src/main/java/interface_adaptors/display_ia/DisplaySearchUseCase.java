package interface_adaptors.display_ia;

import interface_adaptors.AbstractDisplayUseCase;
import interface_adaptors.SearchBarViewModel;

public class DisplaySearchUseCase extends AbstractDisplayUseCase {

    private static DisplaySearchUseCase instance;

    /**
     * Gets instance of singleton
     * @return instance
     */
    public static DisplaySearchUseCase getInstance() {
        if (instance == null) {instance = new DisplaySearchUseCase();}
        return instance;
    }

    public void displaySearchBar() {
        try {
            // Send to ViewModel
            SearchBarViewModel.getInstance().updateView(null);
        }
        catch ( Exception e ) {
            System.out.println(e.getStackTrace());
        }
    }

    public void search(String text) {
        try {
            // Fetch songs from database
//            TODO: rename functions to appropriate method
//            ArrayList<Song> songs = doSearchSongs(text);
//            ArrayList<User> users = doSearchUsers(text);
            //ArrayList<Album> albums = doSearchAlbums(text);
            // Send to ViewModel
//            SearchResultsViewModel.getInstance().updateView(songs, users);
        }
        catch ( Exception e ) {
            System.out.println(e.getStackTrace());
        }
    }
/*
    private ArrayList<Song> doSearchSongs(String text) {

    }

    private ArrayList<Album> doSearchAlbums(String text) {

    }

    private ArrayList<User> doSearchUsers(String text) {

    }
*/
}

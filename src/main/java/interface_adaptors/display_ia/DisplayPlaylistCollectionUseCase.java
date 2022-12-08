//package interface_adaptors.display_ia;
//
//import entities.playlist_entities.Playlist;
//import entities.user_entities.User;
//import interface_adaptors.AbstractDisplayUseCase;
//import interface_adaptors.PlaylistCollectionViewModel;
//
//import java.util.ArrayList;
//
//public class DisplayPlaylistCollectionUseCase extends AbstractDisplayUseCase {
//
//    private static DisplayPlaylistCollectionUseCase instance;
//
//    /**
//     * Gets instance of singleton
//     * @return instance
//     */
//    public static DisplayPlaylistCollectionUseCase getInstance() {
//        if (instance == null) {instance = new DisplayPlaylistCollectionUseCase();}
//        return (DisplayPlaylistCollectionUseCase)instance;
//    }
//
//    public void displayPlaylists(User user) {
//        // Fetch users from database
//        ArrayList<Playlist> playlists = getPlaylists(user);
//        // Send to ViewModel
//        PlaylistCollectionViewModel.getInstance().updateView(playlists);
//    }
//
//    //TODO: should be in User class?
//    private ArrayList<Playlist> getPlaylists(User user) {
//        ArrayList<Playlist> playlists = new ArrayList<Playlist>();
//        return playlists;
//    }
//
//}
//

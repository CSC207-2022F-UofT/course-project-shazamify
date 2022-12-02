package interface_adaptors;

import entities.user_entities.User;

public class PlaylistCollectionController {

    public static void displayPlaylists(User user){
        DisplayPlaylistCollectionUseCase.getInstance().displayPlaylists(user);
    }

}

package interface_adaptors;

import user.entities.User;

public class PlaylistCollectionController {

    public static void displayPlaylists(User user){
        DisplayPlaylistCollectionUseCase.getInstance().displayPlaylists(user);
    }

}

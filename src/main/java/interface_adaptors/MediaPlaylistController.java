package interface_adaptors;

import shazamify.entity.Playlist;

public class MediaPlaylistController {

    public static void displayPlaylist(Playlist playlist){
        DisplayRecordUseCase.getInstance().displayPlaylist(playlist);
    }

}

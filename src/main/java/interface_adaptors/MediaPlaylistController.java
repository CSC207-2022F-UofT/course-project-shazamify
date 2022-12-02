package interface_adaptors;


import entities.playlist_entities.Playlist;

public class MediaPlaylistController {

    public static void displayPlaylist(Playlist playlist){
        DisplayRecordUseCase.getInstance().displayPlaylist(playlist);
    }

}

package screen.playlist_screen;

import entities.playlist_entities.Playlist;

public class RecordViewModel {
    private Playlist playlist;

    public void setPlaylist(Playlist playlist){
        this.playlist = playlist;
    }

    public Playlist getPlaylist(){
        return playlist;
    }
}

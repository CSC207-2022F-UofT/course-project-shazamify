package abr.playlist_abr;

import entities.playlist_entities.Playlist;

public class PlaylistCreateResponseModel {
    public Playlist playlist;

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Playlist getPlaylist() {return this.playlist;}
}

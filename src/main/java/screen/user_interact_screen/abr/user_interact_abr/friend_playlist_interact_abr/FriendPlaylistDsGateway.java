package screen.user_interact_screen.abr.user_interact_abr.friend_playlist_interact_abr;

import entities.playlist_entities.Playlist;

import java.util.ArrayList;

public interface FriendPlaylistDsGateway {
    ArrayList<Playlist> getUserPlaylist(String userName);
}

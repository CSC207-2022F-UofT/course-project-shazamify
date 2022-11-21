package abr.user_interact_abr.friend_playlist_interact_abr;

import abr.user_interact_abr.manage_friend_request_abr.FriendManagerDsGateway;
import entities.playlist_entities.Playlist;
import entities.playlist_entities.Privacy;

import java.util.ArrayList;
import java.util.Objects;

public class FilterViewablePlaylist implements CheckFriendPlaylistInputBoundary {

    final FriendManagerDsGateway userDsGateway;
    final FriendPlaylistDsGateway playlistDsGateway;

    public FilterViewablePlaylist(FriendManagerDsGateway userDsGateway, FriendPlaylistDsGateway playlistDsGateway) {
        this.userDsGateway = userDsGateway;
        this.playlistDsGateway = playlistDsGateway;
    }

    @Override
    public ArrayList<String> returnViewablePlaylist(String userName, String friendName) {
        // check if user is friend with friendName
        if (Objects.equals(userDsGateway.getFriendList(friendName).get(userName), "friend")){
            return getFriendViewablePlaylist(playlistDsGateway.getUserPlaylist(friendName));
        } else { // user is not a friend with friendName, return only publicly available playlists
            return getPublicViewablePlaylist(playlistDsGateway.getUserPlaylist(friendName));
        }
    }
    private ArrayList<String> getFriendViewablePlaylist(ArrayList<Playlist> friendPlaylists){
        ArrayList<String> friendViewablePlaylist = new ArrayList<>();
        for (Playlist playlist : friendPlaylists) {
            if (playlist.getPrivacy() != Privacy.PRIVATE) {
                friendViewablePlaylist.add(playlist.toString());
            }
        }
        return friendViewablePlaylist;
    }

    private ArrayList<String> getPublicViewablePlaylist(ArrayList<Playlist> friendPlaylists){
        ArrayList<String> publicViewablePlaylist = new ArrayList<>();
        for (Playlist playlist : friendPlaylists) {
            if (playlist.getPrivacy() == Privacy.PUBLIC) {
                publicViewablePlaylist.add(playlist.toString());
            }
        }
        return publicViewablePlaylist;
    }
}

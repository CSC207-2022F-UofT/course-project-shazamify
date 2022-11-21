package screen.user_interact_screen.friend_playlist_interact_screen;

import abr.user_interact_abr.friend_playlist_interact_abr.CheckFriendPlaylistInputBoundary;
import screen.user_interact_screen.friend_manager_screen.TempFriendListObservable;

import java.util.ArrayList;


public class CheckFriendPlaylistController{

    final CheckFriendPlaylistInputBoundary inputBoundary;

    public CheckFriendPlaylistController(CheckFriendPlaylistInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    ArrayList<String> returnFilteredPlaylist(String friendName){
        return inputBoundary.returnViewablePlaylist(TempFriendListObservable.currentUser, friendName);
    }
}

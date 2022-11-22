package interface_adaptors.user_interact_ia;

import abr.user_interact_abr.friend_playlist_interact_abr.CheckFriendPlaylistInputBoundary;

import java.util.ArrayList;


/**
 * all user interaction controllers serve the same purpose: get input data from screen, pass input data to use cases,
 * get output data from user cases, pass output data to screen.
 */
public class CheckFriendPlaylistController{

    final CheckFriendPlaylistInputBoundary inputBoundary;

    public CheckFriendPlaylistController(CheckFriendPlaylistInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public ArrayList<String> returnFilteredPlaylist(String friendName){
        return inputBoundary.returnViewablePlaylist(TempFriendListObservable.currentUser, friendName);
    }
}

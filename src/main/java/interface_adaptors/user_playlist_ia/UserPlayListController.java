package interface_adaptors.user_playlist_ia;

import abr.user_playlist_abr.UserPlaylistInputBoundary;
import abr.user_playlist_abr.UserPlaylistRequestModel;

/**
 * @author David Li
 */
public class UserPlayListController {
    UserPlaylistInputBoundary inputBoundary;
    UserPlaylistRequestModel requestModel = new UserPlaylistRequestModel();
    public UserPlayListController(UserPlaylistInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public void addPlayListInUser(String userName, String PlayListID){
        requestModel.setPlayListID(PlayListID);
        requestModel.setUserName(userName);
        inputBoundary.addToUserPlaylist(requestModel);
    }

    public void deletePlaylistInUser(String userName, String PlayListID){
        requestModel.setPlayListID(PlayListID);
        requestModel.setUserName(userName);
        inputBoundary.deleteInUserPlaylist(requestModel);
    }
}

package interface_adaptors.user_playlist_ia;

import abr.user_playlist_abr.UserPlaylistOutputBoundary;
import abr.user_playlist_abr.UserPlaylistResponseModel;
import interface_adaptors.user_login_ia.UserStatusViewModel;

import java.util.List;

public class UserPlayListPresenter implements UserPlaylistOutputBoundary {
    UserStatusViewModel userStatusViewModel;

    public UserPlayListPresenter(UserStatusViewModel userStatusViewModel){
        this.userStatusViewModel = userStatusViewModel;
    }
    @Override
    public void packageAndPresent(UserPlaylistResponseModel userPlaylistResponseModel) {
        List<String> userPlayListIDs = userPlaylistResponseModel.getUserPlaylistIDs();
        userStatusViewModel.setPlayListIds(userPlayListIDs);
        userStatusViewModel.userUpdated();
    }
}

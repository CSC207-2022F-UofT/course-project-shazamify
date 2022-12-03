package abr.user_playlist_abr;

import java.util.List;

public class UserPlaylistUseCase implements UserPlaylistInputBoundary{
    UserPlaylistOutputBoundary outputBoundary;
    UserPlaylistDatabaseGateway databaseGateway;
    UserPlaylistResponseModel responseModel;

    public UserPlaylistUseCase(UserPlaylistOutputBoundary outputBoundary, UserPlaylistDatabaseGateway databaseGateway){
        this.outputBoundary = outputBoundary;
        this.databaseGateway = databaseGateway;
        this.responseModel = new UserPlaylistResponseModel();
    }
    @Override
    public void addToUserPlaylist(UserPlaylistRequestModel userPlaylistRequestModel) {
        List<String> playList = databaseGateway.addPlaylistInUser(userPlaylistRequestModel.userName, userPlaylistRequestModel.playListID);
        responseModel.setUserPlaylistIDs(playList);
    }

    @Override
    public void deleteInUserPlaylist(UserPlaylistRequestModel userPlaylistRequestModel) {
        List<String> playList = databaseGateway.deletePlaylistInUser(userPlaylistRequestModel.userName, userPlaylistRequestModel.playListID);
        responseModel.setUserPlaylistIDs(playList);
    }
}

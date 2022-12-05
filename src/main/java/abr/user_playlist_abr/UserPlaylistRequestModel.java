package abr.user_playlist_abr;

public class UserPlaylistRequestModel {
    String userName;
    String playListID;

    public String getUserName() {
        return userName;
    }

    public String getPlayListID() {
        return playListID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPlayListID(String playListID) {
        this.playListID = playListID;
    }
}

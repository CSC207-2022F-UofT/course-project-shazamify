package abr.playlist_abr;

import abr.song_abr.SongDAOOutput;
import entities.Song;
import entities.playlist_entities.Playlist;

import java.util.Optional;

/**
 * PlaylistModify Logic
 */
public class PlaylistModifyUseCase implements PlaylistModifyInputBoundary {
    private final PlaylistDAOOutput playlistDAOOutput;
    private final SongDAOOutput songDAOOutput;
    public PlaylistModifyUseCase (PlaylistDAOOutput playlistDAOOutput, SongDAOOutput songDAOOutput){
        this.playlistDAOOutput = playlistDAOOutput;
        this.songDAOOutput = songDAOOutput;
    }

    /**
     * add a song to playlist
     * @param requestModel: modify Playlist's properties
     */
    @Override
    public void addToPlaylist(PlaylistModifyRequestModel requestModel) {
        Optional<Playlist> playlist = this.playlistDAOOutput.findById(requestModel.plID);
        Optional<Song> song = this.songDAOOutput.findById(requestModel.songID);
        if (playlist.isPresent() && song.isPresent()) {
            playlist.get().addSong(requestModel.songID);
            PlaylistResponseModel playlistResM = new PlaylistResponseModel(playlist.get().getId());
            //TODO: updateView(playlistResM)
        }
    }

    /**
     * delete a song from playlist
     * @param requestModel: modify Playlist's properties
     */
    @Override
    public void deleteSong(PlaylistModifyRequestModel requestModel) {
        Optional<Playlist> playlist = this.playlistDAOOutput.findById(requestModel.plID);
        Optional<Song> song = this.songDAOOutput.findById(requestModel.songID);
        if (playlist.isPresent() && song.isPresent()) {
            playlist.get().deleteSong(requestModel.songID);
            PlaylistResponseModel playlistResM = new PlaylistResponseModel(playlist.get().getId());
            //TODO: updateView(playlistResM)
        }

    }

    /**
     * change the privacy of a playlist
     * @param requestModel: modify Playlist's properties
     */
    @Override
    public void setPrivacy(PlaylistModifyRequestModel requestModel) {
        Optional<Playlist> playlist = this.playlistDAOOutput.findById(requestModel.plID);
        if (playlist.isPresent()){
            playlist.get().setPrivacy(requestModel.privacy);
            PlaylistResponseModel playlistResM = new PlaylistResponseModel(playlist.get().getId());

            //TODO: updateView(playlistResM)
        }

    }

    /**
     * set the name of the playlist
     * @param requestModel: modify Playlist's properties
     */
    @Override
    public void setName(PlaylistModifyRequestModel requestModel) {
        Optional<Playlist> playlist = this.playlistDAOOutput.findById(requestModel.plID);
        if (playlist.isPresent()) {
            playlist.get().setName(requestModel.plName);
            PlaylistResponseModel playlistResM = new PlaylistResponseModel(playlist.get().getId());

            //TODO: updateView(playlistResM)
        }

    }

    /**
     * reorder playlist's contents
     * @param requestModel: modify Playlist's properties
     */
    @Override
    public void reOrderPL(PlaylistModifyRequestModel requestModel) {
        Optional<Playlist> playlist = this.playlistDAOOutput.findById(requestModel.plID);

        int index = requestModel.songIndex;
        if (playlist.isPresent() && (index < playlist.get().getSongs().size())) {
            playlist.get().reOrderSongs(requestModel.songID, index);
            PlaylistResponseModel playlistResM = new PlaylistResponseModel(playlist.get().getId());

            //TODO: updateView(playlistResM)
        }

    }
}

package abr.playlist_abr;

import abr.song_abr.SongDAOOutput;
import entities.Song;
import entities.playlist_entities.Playlist;

import java.util.Optional;

public class PlaylistModifyUseCase implements PlaylistModifyInputBoundary {
    private final PlaylistModifyOutputBoundary outputBoundary;
    private final PlaylistDAOOutput playlistDAOOutput;
    private final SongDAOOutput songDAOOutput;
    public PlaylistModifyUseCase (PlaylistModifyOutputBoundary outputBoundary, PlaylistDAOOutput playlistDAOOutput, SongDAOOutput songDAOOutput){
        this.outputBoundary = outputBoundary;
        this.playlistDAOOutput = playlistDAOOutput;
        this.songDAOOutput = songDAOOutput;
    }
    @Override
    public void addToPlaylist(PlaylistModifyRequestModel requestModel) {
        Optional<Playlist> playlist = this.playlistDAOOutput.findById(requestModel.plID);
        Optional<Song> song = this.songDAOOutput.findById(requestModel.songID);
        if (playlist.isPresent() && song.isPresent()) {
            playlist.get().addSong(song.get());
        }
    }

    @Override
    public void deleteSong(PlaylistModifyRequestModel requestModel) {
        Optional<Playlist> playlist = this.playlistDAOOutput.findById(requestModel.plID);
        Optional<Song> song = this.songDAOOutput.findById(requestModel.songID);
        if (playlist.isPresent() && song.isPresent()) {
            playlist.get().deleteSong(song.get());
        }

    }

    @Override
    public void setPrivacy(PlaylistModifyRequestModel requestModel) {
        Optional<Playlist> playlist = this.playlistDAOOutput.findById(requestModel.plID);
        if (playlist.isPresent()){
            playlist.get().setPrivacy(requestModel.privacy);
        }

    }

    @Override
    public void setName(PlaylistModifyRequestModel requestModel) {
        Optional<Playlist> playlist = this.playlistDAOOutput.findById(requestModel.plID);
        if (playlist.isPresent()) {
            playlist.get().setName(requestModel.plName);
        }

    }

    @Override
    public void reOrderPL(PlaylistModifyRequestModel requestModel) {
        Optional<Playlist> playlist = this.playlistDAOOutput.findById(requestModel.plID);
        Optional<Song> song = this.songDAOOutput.findById(requestModel.songID);
        int index = requestModel.songIndex;
        if (playlist.isPresent() && song.isPresent() && (index < playlist.get().getSongs().size())) {
            playlist.get().reOrderSongs(song.get(), index);
        }

    }
}

package interface_adaptors.song_player_ia;

import abr.SongPlayerUseCase;
import entities.Song;
import interface_adaptors.display_ia.DisplaySongPlayerUseCase;

public class SongPlayerController {

    public static void displaySongPlayer(Song song){
        SongPlayerUseCase.getInstance().displaySongPlayer(song);
    }
    public static void playSong(){
        SongPlayerUseCase.getInstance().playSong();
    }
    public static void stopSong(){
        SongPlayerUseCase.getInstance().stopSong();
    }
    public static void pauseSong(){
        SongPlayerUseCase.getInstance().pauseSong();
    }
    public static void seekStartSong(){
        SongPlayerUseCase.getInstance().seekStartSong();
    }
    public static void seekEndSong(){
        SongPlayerUseCase.getInstance().seekEndSong();
    }

}

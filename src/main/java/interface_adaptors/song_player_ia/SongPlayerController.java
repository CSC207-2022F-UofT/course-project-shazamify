package interface_adaptors.song_player_ia;

import entities.Song;
import interface_adaptors.display_ia.DisplaySongPlayerUseCase;

public class SongPlayerController {
    //TODO: Separate displayusecase from the controller usecases

    public static void displaySongPlayer(Song song){
        DisplaySongPlayerUseCase.getInstance().displaySongPlayer(song);
    }
    public static void playSong(){
        DisplaySongPlayerUseCase.getInstance().playSong();
    }
    public static void stopSong(){
        DisplaySongPlayerUseCase.getInstance().stopSong();
    }
    public static void pauseSong(){
        DisplaySongPlayerUseCase.getInstance().pauseSong();
    }
    public static void seekStartSong(){
        DisplaySongPlayerUseCase.getInstance().seekStartSong();
    }
    public static void seekEndSong(){
        DisplaySongPlayerUseCase.getInstance().seekEndSong();
    }

}

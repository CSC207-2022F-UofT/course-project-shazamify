package interface_adaptors;

import entities.Song;

public class SongPlayerController {

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

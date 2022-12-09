package interface_adaptors.song_player_ia;

import interface_adaptors.display_ia.SongPlayerAudio;

public class SongPlayerController {

    public static void displaySongPlayer(String song_id){
        SongPlayerAudio.getInstance().displaySongPlayer(song_id);
    }
    public static void playSong(){
        SongPlayerAudio.getInstance().playSong();
    }
    public static void stopSong(){
        SongPlayerAudio.getInstance().stopSong();
    }
    public static void pauseSong(){ SongPlayerAudio.getInstance().pauseSong();}
    public static void seekStartSong(){SongPlayerAudio.getInstance().seekStartSong();}
    public static void seekEndSong(){
        SongPlayerAudio.getInstance().seekEndSong();
    }

}

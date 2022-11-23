package interface_adaptors;

import entities.Song;

public class SongVisualizerController {

    public static void visualizeSong(Song song){
        SongVisualizerUseCase.getInstance().visualizeSong(song);
    }

}

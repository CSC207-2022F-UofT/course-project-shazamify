package interface_adaptors.visualizer_ia;

import entities.Song;

public class SongVisualizerController {

    public static void visualizeSong(Song song){
        SongVisualizerUseCase.getInstance().visualizeSong(song);
    }

}

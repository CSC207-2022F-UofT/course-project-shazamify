package abr.search_engine_abr;

import entities.Song;

import java.util.List;

public interface SearchSongInputBoundary {
    public void sendSearchSongsToViewModel(String searchName);

    public void updateView();
}

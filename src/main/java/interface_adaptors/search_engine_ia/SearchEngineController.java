package interface_adaptors.search_engine_ia;

import abr.search_engine_abr.SearchSongInputBoundary;
import abr.search_engine_abr.SearchUserInputBoundary;

public class SearchEngineController {
    SearchSongInputBoundary searchSongInputBoundary;
    SearchUserInputBoundary searchUserInputBoundary;
    public SearchEngineController(SearchSongInputBoundary searchSongInputBoundary, SearchUserInputBoundary userInputBoundary){
        this.searchSongInputBoundary = searchSongInputBoundary;
        this.searchUserInputBoundary = userInputBoundary;
    }

    public void updateSearchSongResult(String searchText){
        searchSongInputBoundary.sendSearchSongsToViewModel(searchText);
    }

    public void updateSearchUserResult(String searchText){
        searchUserInputBoundary.sendSearchUserToViewModel(searchText);
    }
}

package interface_adaptors.search_engine_ia;

import abr.search_engine_abr.SearchRadioInputBoundary;
import abr.search_engine_abr.SearchSongInputBoundary;
import abr.search_engine_abr.SearchUserInputBoundary;

public class SearchEngineController {
    SearchSongInputBoundary searchSongInputBoundary;
    SearchUserInputBoundary searchUserInputBoundary;

    SearchRadioInputBoundary searchRadioInputBoundary;

    public SearchEngineController(SearchSongInputBoundary searchSongInputBoundary,
                                  SearchUserInputBoundary userInputBoundary,
                                  SearchRadioInputBoundary searchRadioInputBoundary){
        this.searchSongInputBoundary = searchSongInputBoundary;
        this.searchUserInputBoundary = userInputBoundary;
        this.searchRadioInputBoundary = searchRadioInputBoundary;

    }

    public void updateSearchSongResult(String searchText){
        searchSongInputBoundary.sendSearchSongsToViewModel(searchText);
    }

    public void updateSearchUserResult(String searchText){
        searchUserInputBoundary.sendSearchUserToViewModel(searchText);
    }

    public void updateSearchRadioResult(String searchText){
        searchRadioInputBoundary.sendSearchRadioToViewModel(searchText);
    }

    public void updateSearch(){
        searchSongInputBoundary.updateView();
    }

}

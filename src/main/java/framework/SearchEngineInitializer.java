package framework;

import abr.search_engine_abr.*;
import interface_adaptors.search_engine_ia.SearchEngineController;
import interface_adaptors.search_engine_ia.SearchEnginePresenter;

public class SearchEngineInitializer {
    public static SearchEngineController getSearchEngineController(){
        SearchEngineOutputBoundary searchEnginePresenter = new SearchEnginePresenter();

        SearchUserInputBoundary userInputBoundary = new SearchUserAbr(searchEnginePresenter);
        SearchSongInputBoundary songInputBoundary = new SearchSongAbr(searchEnginePresenter);
        SearchRadioInputBoundary radioInputBoundary = new RadioSearch(searchEnginePresenter);

        return new SearchEngineController(songInputBoundary, userInputBoundary, radioInputBoundary);
    }
}

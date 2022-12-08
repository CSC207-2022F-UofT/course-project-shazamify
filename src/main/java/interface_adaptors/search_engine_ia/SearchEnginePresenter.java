package interface_adaptors.search_engine_ia;

import abr.search_engine_abr.SearchEngineOutputBoundary;
import abr.search_engine_abr.SearchEngineResponseModel;
import interface_adaptors.SearchResultsViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchEnginePresenter implements SearchEngineOutputBoundary {

    @Override
    public void packageAndPresentUser(SearchEngineResponseModel responseModel) {
        System.out.println("should retrieve");
        SearchResultsViewModel.getInstance().updateViewUser(responseModel.getUserSearchResult());
    }

    @Override
    public void packageAndPresentSongs(SearchEngineResponseModel responseModel) {
        SearchResultsViewModel.getInstance().updateViewSongs(responseModel.getSongSearchResult());
    }

    @Override
    public void packageAndPresentRadio(SearchEngineResponseModel responseModel){
        SearchResultsViewModel.getInstance().updateViewRadio(responseModel.getRadioSearchResult());
    }

    public void present(){
        SearchResultsViewModel.getInstance().updateView();
    }


}

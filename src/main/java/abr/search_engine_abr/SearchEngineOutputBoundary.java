package abr.search_engine_abr;

import java.util.List;

public interface SearchEngineOutputBoundary {
    public void packageAndPresentUser(SearchEngineResponseModel responseModel);
    public void packageAndPresentSongs(SearchEngineResponseModel responseModel);
    void packageAndPresentRadio(SearchEngineResponseModel responseModel);
}

package abr.search_engine_abr;

public interface SearchEngineOutputBoundary {
    public void packageAndPresentUser(SearchEngineResponseModel responseModel);
    public void packageAndPresentSongs(SearchEngineResponseModel responseModel);
    void packageAndPresentRadio(SearchEngineResponseModel responseModel);
    public void present();
}

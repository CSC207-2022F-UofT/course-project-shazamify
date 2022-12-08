package abr.search_engine_abr;

import java.util.List;

public class SearchEngineResponseModel {
    private List<String> userSearchResult;
    private List<String> songSearchResult;

    private List<String> radioSearchResult;

    public List<String> getSongSearchResult() {
        return songSearchResult;
    }

    public List<String> getUserSearchResult() {
        return userSearchResult;
    }

    public List<String> getRadioSearchResult(){ return radioSearchResult; }

    public void setSongSearchResult(List<String> songSearchResult) {
        this.songSearchResult = songSearchResult;
    }

    public void setUserSearchResult(List<String> userSearchResult) {
        this.userSearchResult = userSearchResult;
    }

    public void setRadioSearchResult(List<String> radioSearchResult) { this.radioSearchResult = radioSearchResult; }
}

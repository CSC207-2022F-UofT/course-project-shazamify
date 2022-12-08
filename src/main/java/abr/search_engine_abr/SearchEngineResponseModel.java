package abr.search_engine_abr;

import java.util.List;

public class SearchEngineResponseModel {
    private List<String> userSearchResult;
    private List<String> songSearchResult;

    public List<String> getSongSearchResult() {
        return songSearchResult;
    }

    public List<String> getUserSearchResult() {
        return userSearchResult;
    }

    public void setSongSearchResult(List<String> songSearchResult) {
        this.songSearchResult = songSearchResult;
    }

    public void setUserSearchResult(List<String> userSearchResult) {
        this.userSearchResult = userSearchResult;
    }
}

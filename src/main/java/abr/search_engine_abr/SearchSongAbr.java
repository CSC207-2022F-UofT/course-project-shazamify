package abr.search_engine_abr;

import abr.song_abr.SongDAOOutput;
import com.mongodb.client.FindIterable;
import ds.song_ds.SongDAOOutputImpl;
import entities.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolang05
 * @date 2022/11/13/17:01
 */
public class SearchSongAbr implements SearchSongInputBoundary{
    private SongLibrary songLibrary = new SongLibrary();
    private int limitCount = 5;
    private SearchEngineOutputBoundary outputBoundary;
    private SearchEngineResponseModel responseModel;
    public SearchSongAbr(SearchEngineOutputBoundary outputBoundary){
        this.responseModel = new SearchEngineResponseModel();
        this.outputBoundary = outputBoundary;
    }
    public void updateView(){
        outputBoundary.present();
    }

    @Override
    public void sendSearchSongsToViewModel(String searchName){
        List<Song> resultedSong = searchSongs(searchName);
        List<String> resultedSongIds = new ArrayList<>();

        for (Song song: resultedSong){
            resultedSongIds.add(song.getId());
        }

        responseModel.setSongSearchResult(resultedSongIds);
        outputBoundary.packageAndPresentSongs(responseModel);
    }

    /***
     *  Search song by name, first match equals, then match starts with, and finally matches contains
     *  @param searchContent songName
     *  @return List<Song>
     */

    public List<Song> searchSongs(String searchContent) {
//        String textForSearch = searchContent.toUpperCase();
//        List<Song> searchResult = new ArrayList<>();
//        List<Song> startWithResult = new ArrayList<>();
//        List<Song> containsResult = new ArrayList<>();
//        List<Song> songList = songLibrary.getSongs();
//        for (int i = 0; i < songList.size(); i++) {
//            if (songList.get(i).getName().toUpperCase().equals(textForSearch)) {
//                searchResult.add(songList.get(i));
//            } else if (songList.get(i).getName().toUpperCase().startsWith(textForSearch)) {
//                startWithResult.add(songList.get(i));
//            } else if (songList.get(i).getName().toUpperCase().contains(textForSearch)) {
//                containsResult.add(songList.get(i));
//            }
//        }
//        searchResult.addAll(startWithResult);
//        searchResult.addAll(containsResult);
//        //return limitCount songs
//        if (searchResult.size() > limitCount) {
//            return searchResult.subList(0, limitCount);
//        } else {
//            return searchResult;
//        }

        SongDAOOutput songDAOOutput = new SongDAOOutputImpl();
        FindIterable<Song> results = songDAOOutput.findByNameList(searchContent);

        ArrayList<Song> songResults = new ArrayList<>();
        for(Song s : results) {
            songResults.add(s);
        }
        return songResults;

    }


}

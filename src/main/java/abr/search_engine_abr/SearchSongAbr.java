package abr.search_engine_abr;

import entities.*;
import entities.Record;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhaolang05
 * @date 2022/11/13/17:01
 */
public class SearchSongAbr {
    private SongLibrary songLibrary = new SongLibrary();
    private int limitCount = 5;

    public List<Song> searchSongs(String searchContent) {
        String textForSearch = searchContent.toUpperCase();
        List<Song> songResults = songLibrary.getSongs().stream()
                .filter(song -> song.getName().toUpperCase().contains(textForSearch))
                .sorted((x, y) -> {
                    return getSortedCompareResult(x, y, textForSearch);
                })
                .collect(Collectors.toList());
        return songResults;
    }

    private int getSortedCompareResult(Record x, Record y, String textForSearch) {
        boolean xEquals = x.getName().toUpperCase().equals(textForSearch);
        boolean yEquals = y.getName().toUpperCase().equals(textForSearch);
        if (xEquals && yEquals) {
            return 0;
        }
        if (xEquals) {
            return -1;
        }
        if (yEquals) {
            return 1;
        }
        boolean xStartWith = x.getName().toUpperCase().startsWith(textForSearch);
        boolean yStartWith = y.getName().toUpperCase().startsWith(textForSearch);
        if (xStartWith && yStartWith) {
            return 0;
        }
        if (xStartWith) {
            return -1;
        }
        if (yStartWith) {
            return 1;
        }

        boolean xContains = x.getName().toUpperCase().contains(" " + textForSearch);
        boolean yContains = y.getName().toUpperCase().contains(" " + textForSearch);
        if (xContains && yContains) {
            return 0;
        }
        if (xContains) {
            return -1;
        }
        if (yContains) {
            return 1;
        }
        return 0;
    }

}

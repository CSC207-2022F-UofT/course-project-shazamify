package abr.radio_abr;
import entities.radio_entities.RadioStation;

import java.util.ArrayList;
import java.util.List;

/***
 * @author cynth
 * @since 2022-12-01
 */

public class RadioSearch {
//    Get the search query from SearchEngine (specifically for RadioStations)
//    and plug it into the API.
//    Converts all the results into RadioStation Objects and present them.
//
//    Return list of the results of the RadioStations
    private int limitCount = 5;
    private final StationLibrary stationLibrary = new StationLibrary();

    /***
     *  Search radio stations by name, first match equals, then match starts with, and finally matches contains
     *  @param searchContent stationName
     *  @return List<RadioStation>
     */

    public List<RadioStation> searchRadio(String searchContent) {

        String textForSearch = searchContent.toUpperCase();
        List<RadioStation> searchResult = new ArrayList<>();
        List<RadioStation> startsWithResult = new ArrayList<>();
        List<RadioStation> containsResult = new ArrayList<>();
        List<RadioStation> stationList = stationLibrary.getStations(); // Fix this soon!

        for (RadioStation radioStation : stationList) {
            if (radioStation.getName().toUpperCase().equals(textForSearch)) {
                searchResult.add(radioStation);

            } else if (radioStation.getName().toUpperCase().startsWith(textForSearch)) {
                startsWithResult.add(radioStation);

            } else if (radioStation.getName().toUpperCase().contains(textForSearch)) {
                containsResult.add(radioStation);
            }
        }

        searchResult.addAll(startsWithResult);
        searchResult.addAll(containsResult);
        //return limitCount songs
        if (searchResult.size() > limitCount) {
            return searchResult.subList(0, limitCount);
        } else {
            return searchResult;
        }


    }
}

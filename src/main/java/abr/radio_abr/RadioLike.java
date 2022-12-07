package abr.radio_abr;

import entities.radio_entities.RadioStation;

import java.util.List;

/***
 * @author cynth
 * @since 2022-12-01
 */

public class RadioLike {
    /***
     *  Responsibility of the function is to track the like/unlike radio station operation.
     *  If the user activates likeStation and the station is already liked, it will be unlike and the favourite station collection is updated.
     *  If the user actives likeStation and the station is not already liked, it will be liked and then favourite station collection will be updated.
     *  @param stationName String
     */
    public static void likeStation(String stationName){

        // We search through our selection of RadioStations to find the correct one.
        StationLibrary stationSelection = new StationLibrary();
        List<RadioStation> stationList = stationSelection.getStations();

        RadioStation station;

        for (RadioStation obj : stationList) {
            if (obj.getName().equals(stationName)){
                station = obj;

                boolean likedStatus = station.getLiked();

                if (!likedStatus) {
                    // If the station is not currently liked, then we add it to the hashmap and then change value of station's liked status.
                    RadioCollectionUpdate.addStation(station);
                    station.like = true;
                }
                else {
                    // Otherwise, we remove it from the hashmap and change value of station's liked status.
                    RadioCollectionUpdate.removeStation(stationName);
                    station.like = false;
                }
                return;
            }
        }



    }
}

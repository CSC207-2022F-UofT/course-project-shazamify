package abr.radio_abr;


import entities.radio_entities.FavouriteRadioCollection;
import entities.radio_entities.RadioStation;

/***
 * @author cynth
 * @since 2022-12-01
 */
public class RadioCollectionUpdate {
    // The purpose of this class is to update the collection of Radio Stations.

    /***
     *  Adds a RadioStation object to the Favourite Radio Station collection hashmap. The key is set as the station's name.
     *  @param station RadioStation
     */
    public static void addStation(RadioStation station){
        String name = station.getName();
        FavouriteRadioCollection.favouriteRadioStations.put(name, station);
    }

    /***
     *  Removes a RadioStation object to the Favourite Radio Station collection hashmap. Uses the key - the station's name - to locate
     *  and remove the object.
     *  @param name String
     */
    // Creating a method to remove a Radio Station from the HashMap.
    public static void removeStation(String name){
        FavouriteRadioCollection.favouriteRadioStations.remove(name);
    }
}

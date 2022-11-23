package abr.radio_abr;


import entities.radio_entities.FavouriteRadioCollection;

/***
 * @author cynth
 */
public class RadioCollectionUpdate {
    // The purpose of this class is to update the collection of Radio Stations.

    // Creating a method to add a new Radio Station to the HashMap.
    public static void addStation(String name, String id){
        // Will need to take the ID from the API as well as Name.
        FavouriteRadioCollection.favouriteRadioStations.put(id, name);
    }

    // Creating a method to remove a Radio Station from the HashMap.
    public static void removeStation(String id){
        FavouriteRadioCollection.favouriteRadioStations.remove(id);
    }
}

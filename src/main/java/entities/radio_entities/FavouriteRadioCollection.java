package entities.radio_entities;



import java.util.HashMap;

/***
 * @author cynth
 * @since 2022-12-01
 */
public class FavouriteRadioCollection {
    // This is an entity that is meant to keep track of all Radio Stations that
    // have been favourited by the user. This is not a playlist - this is quite
    // literally just a library of Radio Stations that will make it easy to access.

    // There are two possible ways we are going to do this.

    // Hashmap that stores the actual Station Object itself, with the
    // name of the station as the key.

    public String name = "Liked Radio Stations";

    // This creates/initializes the HashMap object that we're going to be using.
    public static HashMap<String, RadioStation> favouriteRadioStations = new HashMap<String, RadioStation>();

    public RadioStation getStation(String name){

        return favouriteRadioStations.get(name);

    }
}

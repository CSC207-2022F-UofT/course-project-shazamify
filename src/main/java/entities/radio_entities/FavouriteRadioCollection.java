package entities.radio_entities;



import java.util.HashMap;

/***
 * @author cynth
 */
public class FavouriteRadioCollection {
    // This is an entity that is meant to keep track of all Radio Stations that
    // have been favourited by the user. This is not a playlist - this is quite
    // literally just a library of Radio Stations that will make it easy to access.

    // There are two possible ways we are going to do this.

    // First method: Hashmap that stores the IDs, with the keys as the name of radio
    // station itself.

    // Second method: Hashmap that stores the actual Station Object itself, with the
    // name of the station as the key.

    public String name = "Liked Radio Stations";
    private String thumbnailURL = "https://cdn.discordapp.com/attachments/766785448970158182/1044313578066415616/30870.jpg";

    // This creates/initializes the HashMap object that we're going to be using.
    public static HashMap<String, Object> favouriteRadioStations = new HashMap<String, Object>();

    // Creating a method to get a RadioStation by searching through the HashMap.
    // (Version that takes ID and sends it back through API.)

    //public static String getStation(String id){
        // Will be prompted by outside class.
        // return favouriteRadioStations.get(id);

    //}
}

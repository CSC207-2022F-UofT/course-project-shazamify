package abr.radio_abr;

import entities.radio_entities.RadioStation;

/***
 * @author cynth
 */

public class RadioInteractions {
    //This is a Use Case that will have two functions to it. The first on is playingNow -
    // return current song name, open up the radio stream and start playing it.

    // The second function will be likeStation -
    // Allows user to ‘like’ a station and keep it stored somewhere.
    // It will also call RadioCollectionUpdate.

    public void playingNow(){
        // return current song name, open up the radio stream and start playing it.

        // Call SongRecognizer as well
        // RadioPlayer.WHATEVER FUNCTION DOES THIS(streamURL)

        // TODO: complete this
    }

    public void likeStation(String id, Boolean like){
        // Placeholder boolean to show a check on whether it's true that the station value is like or not.
        // TODO: properly figure out how information is coming through into this function.

        if (like) {
            RadioCollectionUpdate.addStation("test", "testing");
            // TODO: implement change value on station object to like on
        }
        else {
            RadioCollectionUpdate.removeStation(id);
            // TODO: implement change value on station object to like off
        }

    }
}

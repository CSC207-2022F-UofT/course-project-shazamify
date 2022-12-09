package interface_adaptors.radio_ia;

import abr.radio_abr.RadioLike;
import abr.radio_abr.RadioPlayer;
import abr.radio_abr.RadioStationInputBoundary;

/***
 * @author cynth
 * @since 2022-12-01
 */
public class RadioControl {

    /**
     * This controller's main purpose is to communicate Radio Station information between the RadioPlayerPresenter
     * as well as DisplayRadioPlayerUseCase.
     */

    final RadioStationInputBoundary inputBoundary;

    public RadioControl(RadioStationInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public static void displayRadioPlayer(String stationID, String stationName){
        DisplayRadioPlayerUseCase.getInstance().displayRadioPlayer(stationName, stationID);
    }

    public static void startStream(String stationID) {
        DisplayRadioPlayerUseCase.getInstance().playStream(stationID);
    }

    public static void stopStream(){
        RadioPlayer.stopStream();
    }

    public static void stationLike(String stationName) {
        RadioLike.likeStation(stationName);
    }

}

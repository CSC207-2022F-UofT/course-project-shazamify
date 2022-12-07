package interface_adaptors.radio_ia;

import abr.radio_abr.RadioStationInputBoundary;
import abr.radio_abr.RadioLike;
import interface_adaptors.radio_ia.DisplayRadioPlayerUseCase;

/***
 * @author cynth
 * @since 2022-12-01
 */
public class RadioControl {
    //TODO: finish this

    /**
     * This controller's main purpose is to commmunicate Radio Station information between the RadioPlayerPresenter
     * as well as various types of Radio interactions.
     */

    final RadioStationInputBoundary inputBoundary;

    public RadioControl(RadioStationInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

//    public void getInformation(String stationName, String streamURL, String thumbnailURL){
//        RadioStationRequestModel requestModel = new RadioStationRequestModel(stationName, streamURL, thumbnailURL);
//    }

    public static void displayRadioPlayer(String stationName){
        DisplayRadioPlayerUseCase.getInstance().displayRadioPlayer(stationName);
        startStream(stationName);
    };

    public static void startStream(String stationName) {
        DisplayRadioPlayerUseCase.getInstance().playStream(stationName);
    }

    public static void stopStream(){
        DisplayRadioPlayerUseCase.getInstance().stopStream();
    }

    public static void stationLike(String stationName) {
        RadioLike.likeStation(stationName);
    }

}

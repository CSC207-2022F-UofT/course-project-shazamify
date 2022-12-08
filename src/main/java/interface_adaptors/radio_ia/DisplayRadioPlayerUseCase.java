package interface_adaptors.radio_ia;


import abr.radio_abr.RadioPlayer;

/**
 * This controller's main purpose is to communicate Radio Station information between the RadioControl
 * as well as the various Radio ABR things.
 */

public class DisplayRadioPlayerUseCase {

    private static DisplayRadioPlayerUseCase instance;

    public static DisplayRadioPlayerUseCase getInstance() {
        if (instance == null) {instance = new DisplayRadioPlayerUseCase();}
        return instance;
    }

    /**
     * Executes use case
     *
     * @param
     */
    public void displayRadioPlayer(String stationID, String stationName) {
        //Send to ViewModel
        RadioPlayerViewModel.getInstance().updateView(stationName, stationID);
    }
    /**
     * Plays the station stream
     */
    public static void playStream(String stationID) {
        try {
            RadioPlayer.playStream(stationID);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Stops playing the song
     */
    public static void stopStream() {
        try {
            RadioPlayer.stopStream();
        }
        catch (Exception e) {

        }
    }

}
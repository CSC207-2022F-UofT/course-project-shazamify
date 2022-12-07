package radio_ia;


import abr.radio_abr.RadioPlayer;

public class DisplayRadioPlayerUseCase {

    // TODO: literally just finish this

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
    public void displayRadioPlayer(String stationName) {
        //Send to ViewModel
        RadioPlayerViewModel.getInstance().updateView(stationName);
    }
    /**
     * Plays the station stream
     */
    public void playStream(String stationName) {
        try {
            RadioPlayer.playStream(stationName);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Stops playing the song
     */
    public void stopStream() {
        try {
            RadioPlayer.stopStream();
        }
        catch (Exception e) {

        }
    }

}

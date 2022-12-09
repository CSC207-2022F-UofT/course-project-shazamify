package radio_test;


import framework.radio_screen.RadioStationUI;

public class RadioPlayerTestExploratory {

    public static void main(String[] args){
        start();
    }

    public static void start(){
        String stationName = "1011 The Beat";
        String stationID = "7558a9d8-9aa3-45cb-b307-d9cc97870f2d";

        RadioStationUI radioStationUI = new RadioStationUI(stationName, stationID);
        radioStationUI.frameSetUp();

    }
}

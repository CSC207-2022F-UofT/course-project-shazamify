package abr.radio_abr;


/**
 * @author cynth
 *
 * The purpose of this RequestModel is to essentially help transfer information through
 * the InputBoundary and thus not violate Clean Architecture.
 */

public class RadioStationRequestModel {
    private final String stationName;
    private final String streamURL;

    private final String stationID;

    public RadioStationRequestModel(String stationName, String streamURL, String stationID){
        this.stationName = stationName;
        this.streamURL = streamURL;
        this.stationID = stationID;

    }

    public String getStationName(){
        return stationName;
    }

    public String getStreamURL(){
        return streamURL;
    }

    public String getStationID(){return stationID;}
}

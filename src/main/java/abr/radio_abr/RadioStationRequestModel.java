package abr.radio_abr;


/**
 * @author cynth
 * The purpose of this Request Model is to allow upper level controllers and such to access entity level information.
 */

public class RadioStationRequestModel {
    private final String stationName;
    private final String streamURL;
    private final String thumbnailURL;

    private final String stationID;

    public RadioStationRequestModel(String stationName, String streamURL, String thumbnailURL, String stationID){
        this.stationName = stationName;
        this.streamURL = streamURL;
        this.thumbnailURL = thumbnailURL;
        this.stationID = stationID;

    }

    public String getStationName(){
        return stationName;
    }

    public String getStreamURL(){
        return streamURL;
    }

    public String getThumbnailURL(){
        return thumbnailURL;
    }

    public String getStationID(){return stationID;}
}

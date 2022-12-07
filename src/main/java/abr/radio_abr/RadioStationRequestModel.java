package abr.radio_abr;


// TODO: Javadocs

public class RadioStationRequestModel {
    private final String stationName;
    private final String streamURL;
    private final String thumbnailURL;

    public RadioStationRequestModel(String stationName, String streamURL, String thumbnailURL){
        this.stationName = stationName;
        this.streamURL = streamURL;
        this.thumbnailURL = thumbnailURL;

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

}

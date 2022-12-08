package abr.radio_abr;

// TODO: Javadocs

public class RadioStationResponseModel {
      private String stationName;
      private String streamURL;
      private String thumbnailURL;
      private String stationID;

    public void setStationName(String stationName){
        this.stationName = stationName;
    }

    public void setStreamURL(String streamURL){
        this.streamURL = streamURL;
    }

    public void setThumbnailURL(String thumbnailURL){
        this.thumbnailURL = thumbnailURL;
    }

    public void setStationID(String stationID){
        this.stationID = stationID;
    }
}

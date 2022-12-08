package abr.radio_abr;

/**
 * @author cynth
 *
 * The purpose of this RequestModel is to essentially help transfer information through
 * the OutputBoundary and thus not violate Clean Architecture.
 */

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

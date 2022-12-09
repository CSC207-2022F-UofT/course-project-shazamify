package abr.radio_abr;

import java.util.List;

/**
 * @author cynth
 *
 * The purpose of this RequestModel is to essentially help transfer information through
 * the OutputBoundary and thus not violate Clean Architecture.
 */

public class RadioStationResponseModel {
      private List<String> stationName;
      private List<String> streamURL;
      private List<String> stationID;

    public void setStationName(List<String> stationName){
        this.stationName = stationName;
    }

    public void setStreamURL(List<String> streamURL){
        this.streamURL = streamURL;
    }

    public void setStationID(List<String> stationID){
        this.stationID = stationID;
    }
}

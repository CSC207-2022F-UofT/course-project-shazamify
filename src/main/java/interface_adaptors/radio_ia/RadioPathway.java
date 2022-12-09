package interface_adaptors.radio_ia;

import abr.radio_abr.RadioStationOutputBoundary;
import abr.radio_abr.RadioStationResponseModel;

import java.util.ArrayList;
import java.util.List;

public class RadioPathway implements RadioStationOutputBoundary {

    private RadioStationOutputBoundary outputBoundary;
    private RadioStationResponseModel responseModel;

    public RadioPathway(RadioStationOutputBoundary outputBoundary, RadioStationResponseModel responseModel){
        this.outputBoundary = outputBoundary;
        this.responseModel = responseModel;

    }

    @Override
    public void packageAndPresent(RadioStationResponseModel responseModel){
        List<String> stationNames = new ArrayList<>();
        List<String> stationIDS = new ArrayList<>();
        List<String> streamURLs = new ArrayList<>();

        responseModel.setStationName(stationNames);
        responseModel.setStreamURL(streamURLs);
        responseModel.setStationID(stationIDS);
    }

}

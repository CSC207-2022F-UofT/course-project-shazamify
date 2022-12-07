package interface_adaptors.radio_ia;

import abr.radio_abr.RadioStationOutputBoundary;
import abr.radio_abr.RadioStationResponseModel;

public class RadioPlayerPresenter implements RadioStationOutputBoundary {
    /***
     * The queue presenter is responsible for taking the response model list of songs and packaging it for the view model.
     */

    RadioPlayerViewModel viewModel;

    public RadioPlayerPresenter(RadioPlayerViewModel radioPlayerViewModel){
        this.viewModel = radioPlayerViewModel;
    }

    @Override
    public void packageAndPresent(RadioStationResponseModel responseModel){
        viewModel.updateView(responseModel.stationName);
    }
}

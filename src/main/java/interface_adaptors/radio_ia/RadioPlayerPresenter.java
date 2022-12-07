package interface_adaptors.radio_ia;

import abr.radio_abr.RadioStationInputBoundary;
import abr.radio_abr.RadioStationRequestModel;

public class RadioPlayerPresenter implements RadioStationInputBoundary {
    /***
     * The queue presenter is responsible for taking the response model list of songs and packaging it for the view model.
     */

    RadioPlayerViewModel viewModel;

    public RadioPlayerPresenter(RadioPlayerViewModel radioPlayerViewModel){
        this.viewModel = radioPlayerViewModel;
    }

    @Override
    public void get(RadioStationRequestModel requestModel){
        viewModel.updateView(requestModel.getStationName(), requestModel.getStationID());
    }
}

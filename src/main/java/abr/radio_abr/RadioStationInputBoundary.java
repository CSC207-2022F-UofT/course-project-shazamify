package abr.radio_abr;

import radio_ia.RadioPlayerViewModel;

/***
 * RadioStationInputBoundary exists to serve as an input boundary between other classes and the request model.
 */
public interface RadioStationInputBoundary {
    RadioPlayerViewModel playingRadio(RadioStationRequestModel requestModel);
}

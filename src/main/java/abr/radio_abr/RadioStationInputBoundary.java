package abr.radio_abr;

import interface_adaptors.radio_ia.RadioPlayerViewModel;

import java.util.ArrayList;

/***
 * RadioStationInputBoundary exists to serve as an input boundary between other classes and the request model.
 */
public interface RadioStationInputBoundary {
    RadioPlayerViewModel playingRadio(RadioStationRequestModel requestModel);
}

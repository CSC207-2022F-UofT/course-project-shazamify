package abr.radio_abr;


/***
 * RadioStationInputBoundary exists to serve as an input boundary between other classes and the request model.
 */
public interface RadioStationInputBoundary {
    void get(RadioStationRequestModel requestModel);
}

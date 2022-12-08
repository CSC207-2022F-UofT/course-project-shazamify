package abr.radio_abr;

/***
 * RadioStationOutput exists to serve as an output boundary between other classes and the response model, offering up information
 * to classes when they require it, without them needing to cross lines in our clean architecture.
 */
public interface RadioStationOutputBoundary {
    void packageAndPresent(RadioStationResponseModel responseModel);
}

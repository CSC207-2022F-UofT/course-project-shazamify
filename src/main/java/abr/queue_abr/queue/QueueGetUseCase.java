package abr.queue_abr.queue;

//TODO update javadocs
/***
 * The queue use case contains a facade class which determines what the new queue should be. It returns an updated
 * response model containing the new and updated queue list.
 */
public class QueueGetUseCase implements QueueGetInputBoundary {

    private final QueueGetHelper queueGetHelper = new QueueGetHelper();
    private final QueueGetOutputBoundary getOutputBoundary;

    /***
     * The constructor consists of an output boundary because it needs to send data back up through an interface,
     * with the present method helping to draw that connection without violating Clean Architecture dependency rules
     * @param getOutputBoundary - The output boundary that the presenter will use to package and present data.
     */
    public QueueGetUseCase(QueueGetOutputBoundary getOutputBoundary) {
        this.getOutputBoundary = getOutputBoundary;
    }

    /***
     * Overrides the input boundary method and creates a response model with data prepared by the queue helper
     * in for it to be packaged by the output boundary.
     * @param getRequestModel - The list of songs that the queue should be updated to. It should also be passed onto
     *                     the output boundary in preparation for presenting.
     */
    @Override
    public void get(QueueGetRequestModel getRequestModel) {
        QueueGetResponseModel getResponseModel = new QueueGetResponseModel();
        QueueGetDTO queueGetDTO = queueGetHelper.get(getRequestModel, getResponseModel);
        getResponseModel.setSongList(queueGetDTO.songList);

        getOutputBoundary.present(getResponseModel);
    }
}

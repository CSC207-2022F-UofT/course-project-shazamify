package abr.queue_abr.queue;

/***
 * The queue use case contains a facade class which determines what the new queue should be. It returns an updated
 * response model containing the new and updated queue list.
 */
public class QueueUUseCase implements QueueUInputBoundary {

    private final QueueUHelper queueUHelper = new QueueUHelper();
    private final QueueUOutputBoundary uOutputBoundary;

    /***
     * The constructor consists of an output boundary because it needs to send data back up through an interface,
     * with the present method helping to draw that connection without violating Clean Architecture dependency rules
     * @param uOutputBoundary - The output boundary that the presenter will use to package and present data.
     */
    public QueueUUseCase(QueueUOutputBoundary uOutputBoundary) {
        this.uOutputBoundary = uOutputBoundary;
    }

    /***
     * Overrides the input boundary method and creates a response model with data prepared by the queue helper
     * in for it to be packaged by the output boundary.
     * @param uRequestModel - The list of songs that the queue should be updated to. It should also be passed onto
     *                     the output boundary in preparation for presenting.
     */
    @Override
    public void update(QueueURequestModel uRequestModel) {
        QueueUResponseModel uResponseModel = new QueueUResponseModel();
        QueueUResponseModel updatedResponseModel = queueUHelper.update(uRequestModel, uResponseModel);

        uOutputBoundary.present(updatedResponseModel);
    }
}

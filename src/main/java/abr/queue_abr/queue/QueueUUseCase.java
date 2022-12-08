package abr.queue_abr.queue;

/***
 * The queue use case contains a facade class which determines what the new queue should be. It returns an updated
 * response model containing the new and updated queue list.
 */
public class QueueUUseCase implements QueueUInputBoundary {

    private final QueueUHelper queueUHelper = new QueueUHelper();

    /***
     * The constructor consists of an output boundary because it needs to send data back up through an interface,
     * with the present method helping to draw that connection without violating Clean Architecture dependency rules
     */
    public QueueUUseCase() {
    }

    /***
     * Overrides the input boundary method and creates a response model with data prepared by the queue helper
     * in for it to be packaged by the output boundary.
     * @param requestModel - The list of songs that the queue should be updated to. It should also be passed onto
     *                     the output boundary in preparation for presenting.
     */
    @Override
    public void update(QueueURequestModel requestModel) {
        queueUHelper.update(requestModel);
    }
}

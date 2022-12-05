package abr.queue_abr.queue;

//TODO: javadoc
/***
 * The queue use case contains a facade class which determines what the new queue should be. It returns an updated
 * response model containing the new and updated queue list.
 */
public class QueueFUC implements QueueFIB{

    private final QueueFHelper queueFHelper = new QueueFHelper();
    private final QueueFOB fob;

    /***
     * The constructor consists of an output boundary because it needs to send data back up through an interface,
     * with the present method helping to draw that connection without violating Clean Architecture dependency rules
     * @param fob - The output boundary that the presenter will use to package and present data.
     */
    public QueueFUC(QueueFOB fob) {
        this.fob = fob;
    }

    /***
     * Overrides the input boundary method and creates a response model with data prepared by the queue helper
     * in for it to be packaged by the output boundary.
     * @param fReqM - The list of songs that the queue should be updated to. It should also be passed onto
     *                     the output boundary in preparation for presenting.
     */
    @Override
    public void getFirst(QueueFReqM fReqM) {
        QueueFRespM fRespM = new QueueFRespM();
        QueueFDTO queueFDTO = queueFHelper.next(fReqM, fRespM);
        fRespM.setSongList(queueFDTO.songList);
        fRespM.setSongID(queueFDTO.songID);

        fob.present(fRespM);
    }
}

package abr.queue_abr.queue;

/***
 * The queue first use case contains a facade class which determines what the new queue should be. It stores the queue
 * without the first song and the song ID of the first song in a data transfer object. It then calls on the
 * response model's present method, which will bring this information up to the view model.
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
     * @param fReqM - An intentionally empty class.
     */
    @Override
    public void getFirst(QueueFReqM fReqM) {
        QueueFRespM fRespM = new QueueFRespM();
        QueueFDTO queueFDTO = queueFHelper.next();
        fRespM.setSongList(queueFDTO.songList);
        fRespM.setSongID(queueFDTO.songID);

        fob.present(fRespM);
    }
}

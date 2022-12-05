package abr.queue_abr.queue;

/***
 * Queue first output boundary is implemented by the presenter and contains the method to present the first song and the
 * new queue list. It serves as the bridge between the UseCase and the Presenter, without violating any
 * Clean Architecture dependency rules.
 */
public interface QueueFOB {
    void present(QueueFRespM firstResponseModel);
}
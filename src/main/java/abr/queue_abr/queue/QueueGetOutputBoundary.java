package abr.queue_abr.queue;

/***
 * Queue output boundary is implemented by the presenter and contains the method to present the queue's list of song
 * IDs. It serves as the bridge between the UseCase and the Presenter, without violating any Clean Architecture
 * dependency rules.
 */
public interface QueueGetOutputBoundary {
    void present(QueueGetResponseModel getResponseModel);
}

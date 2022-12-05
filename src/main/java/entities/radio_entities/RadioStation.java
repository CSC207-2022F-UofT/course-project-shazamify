package entities.radio_entities;
import java.net.MalformedURLException;
import java.net.URL;

/***
 * @author cynth
 * @since 2022-12-01
 */

public class RadioStation {
    // These variables should stay the same.
    private String id; // A globally unique identifier for the station
    private String name; // The name of the station
    private String streamURL; // The stream URL provided by the user
    private String thumbnailURL; // URL to an icon or picture that represents the stream. (PNG, JPG)

    public boolean like; // If true, it means the station is liked.

    /***
     * Default constructor
     * @param name - The song name
     * @param id - The identifier key for the song
     * @param streamURL - The stream URL provided by the user.
     * @param thumbnailURL - URL to an icon or picture that represents the stream. (PNG, JPG)
     */
    public void RadioStation(String id, String name, String streamURL, String homepageURL, String thumbnailURL, String[] tags,
                                    String country, String[] languages){
        // This function will assign all the basic information (the information that most likely will not change).
        this.id = id;
        this.name = name;
        this.streamURL = streamURL;
        this.thumbnailURL = thumbnailURL;
        this.like = false;

    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public URL getStreamURL(){
        try {
            URL streamLink = new URL(this.streamURL);
            return streamLink;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getThumbnailURL() {
        return this.thumbnailURL;
    }

    public boolean getLiked(){ return this.like; }

    public boolean changeLikeStatus() {
        if (this.like) {
            this.like = false;
        }
        else {
            this.like = true;
        }

        return this.like;
    }

    @Override
    public String toString() {
        return "RadioStation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", streamURL='" + streamURL + '\'' +
                ", thumbnailURL='" + thumbnailURL + '\'' +
                ", like=" + like +
                '}';
    }
}

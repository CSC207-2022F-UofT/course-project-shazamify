package entities.radio_entities;
import java.util.Date;

/***
 * @author cynth
 */

public class RadioStation {
    // These variables should stay the same.
    private String id; // A globally unique identifier for the station
    private String name; // The name of the station
    private String streamURL; // The stream URL provided by the user
    private String homepageURL; // URL to the homepage of the stream.
    private String thumbnailURL; // URL to an icon or picture that represents the stream. (PNG, JPG)
    private String[] tags; // Tags of the stream
    private String country; // Full name of the country
    private String[] languages; // Languages that are spoken in this stream.

    // These variables will likely change over time
    private boolean lastCheckOk; // The current online/offline state of this stream.
    private Date lastCheckTime; // The last time when any radio-browser server checked the online state of this stream
    private Date lastCheckOkTime; // The last time when the stream was checked for the online status with a positive result

    /***
     * Default constructor
     * @param name - The song name
     * @param id - The identifier key for the song
     * @param streamURL - The stream URL provided by the user.
     * @param homepageURL - The song name
     * @param thumbnailURL - URL to an icon or picture that represents the stream. (PNG, JPG)
     * @param tags - Tags of the stream
     * @param country - Full name of the country of origin.
     * @param languages - Languages that are spoken in this stream.
     */
    public void RadioStation(String id, String name, String streamURL, String homepageURL, String thumbnailURL, String[] tags,
                                    String country, String[] languages){
        // This function will assign all the basic information (the information that most likely will not change).
        this.id = id;
        this.name = name;
        this.streamURL = streamURL;
        this.homepageURL = homepageURL;
        this.thumbnailURL = thumbnailURL;
        this.tags = tags;
        this.country = country;
        this.languages = languages;

    }

    /***
     * Updating Constructor
     * @param lastCheckOk - The identifier key for the song
     * @param lastCheckTime - The stream URL provided by the user.
     * @param lastCheckOkTime - The song name
     */
    public void updateRadioStation(boolean lastCheckOk, Date lastCheckTime, Date lastCheckOkTime){
        // This function will update / assign all the information that is likely to change from search to search.
        this.lastCheckOk = lastCheckOk;
        this.lastCheckTime = lastCheckTime;
        this.lastCheckOkTime = lastCheckOkTime;
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public String getStreamURL(){
        return this.streamURL;
    }

    public String getHomepageURL() {
        return this.homepageURL;
    }

    public String getThumbnailURL() {
        return this.thumbnailURL;
    }

    public String getCountry(){
        return this.country;
    }

    public String[] getTags(){
        return this.tags;
    }

    public String[] getLanguages(){
        return this.languages;
    }

    public Date getLastCheckOkTime() {
        return this.lastCheckOkTime;
    }

    public Date getLastCheckTime() {
        return this.lastCheckTime;
    }

    public boolean getLastCheckOk() {
        return this.lastCheckOk;
    }
}

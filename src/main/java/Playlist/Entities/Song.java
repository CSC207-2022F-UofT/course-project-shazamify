package Playlist.Entities;

/***
 * The Song entity class responsible for holding a name, id, and duration.
 */
public class Song extends Record {
    private final String name;
    private final int id;
    private final int duration;

    /***
     * Default constructor
     * @param name - The song name
     * @param id - The identifier key for the song
     * @param duration - The duration of the song in seconds.
     */
    public Song(String name, int id, int duration) {
        this.name = name;
        this.id = id;
        this.duration = duration;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getDuration() {
        return this.duration;
    }
}

package entities;

import java.io.File;
import java.util.ArrayList;

/***
 * The Song entity class responsible for holding a name, id, and duration.
 */
//TODO: does this implement record?
public class Song {
    /**
     * The name of the song to be displayed and the fileName
     */
    private String name;
    /**
     * Unique id of song, matches YouTube id
     */
    private String id;
    /**
     * Duration of the song in seconds
     */
    private int duration;
    /**
     * Path of the mp3 file
     */
    private String filePath;

    private String coverPath;

    private String artist;
    private String year;

    public String getCover() {
        return coverPath;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Empty constructor necessary for MongoDB encoding
     */
    public Song() {

    }

    /**
     * Creates a Song with a name, unique id, duration of the song in seconds, and the appropriate file path based on the name
     *
     * @param name     - The song name
     * @param id       - The identifier key for the song
     * @param duration - The duration of the song in seconds.
     */
    public Song(String name, String id, int duration) {
        this.name = name;
        this.id = id;
        this.duration = duration;
        this.filePath = "src\\main\\resources\\songs\\" + name + ".mp3";
        this.coverPath = "src\\main\\resources\\songs\\" + name + ".webp";
    }

    public Song(String name, String id, int duration, String artist, String year) {
        this.name = name;
        this.id = id;
        this.duration = duration;
        this.filePath = "src\\main\\resources\\songs\\" + name + ".mp3";
        this.coverPath = "src\\main\\resources\\songs\\" + name + ".webp";
        this.artist = artist;
        this.year = year;
    }

    /**
     * @return {@link Song#name}
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name {@link Song#name}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return {@link Song#id}
     */
    public String getId() {
        return this.id;
    }

//    @Override
//    public File getCover() {
//        return null;
//    }
//
//    @Override
//    public String getArtist() {
//        return null;
//    }

    /**
     * @param id {@link Song#id}
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return {@link Song#duration}
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * @param duration {@link Song#duration}
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<Song> getSongs() {
        return null;
    }
//    @Override
//    public Object setSongs(ArrayList<Song> songs) {
//        return null;
//    }

    /**
     * @return String representation of Song. Mainly for debugging purposes.
     */
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", duration=" + duration +
                '}';
    }


    public String getFile() {
        return this.filePath;
    }
}

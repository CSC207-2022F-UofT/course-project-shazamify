package entities;

import java.io.File;
import java.util.ArrayList;

/***
 * The Song entity class responsible for holding a name, id, and duration.
 */
//TODO: does this implement record?
public class Song{
    private String name;
    private String id;
    private int duration;
//    TODO add audiofilePath attribute
    private String filePath;

    /***
     * Empty constructor necessary for MongoDB encoding
     */
    public Song() {

    }

    /***
     *
     * @param name - The song name
     * @param id - The identifier key for the song
     * @param duration - The duration of the song in seconds.
     */
    public Song(String name, String id, int duration) {
        this.name = name;
        this.id = id;
        this.duration = duration;
    }


    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public int getDuration() {
        return this.duration;
    }


    public File getCover() {
        return null;
    }


    public String getArtist() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<Song> getSongs(){return null;}


    public Object setSongs(ArrayList<Song> songs) {
        return null;
    }

    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", duration=" + duration +
                '}';
    }
    


    public File getFile() {
//        TODO: implement method
        return null;
    }
}

package PlaylistEntities;

import Entities.Record;
import Entities.Song;
import java.util.ArrayList;

public class Playlist extends Record {
    private String name;
    private int id;
    private int duration;
    private ArrayList<Song> contents;

    /***
     * Default constructor for playlist
     *
     *
     */
    public Playlist(String name, int id) {
        this.name = name;
        this.id = id;
        this.duration = 0;
        this.contents = new ArrayList<Song>();
    }
    //TODO: initialize with default names
    @Override
    public String getName() {
        return this.name;
    }

    public String setName(String newName) {
        this.name = newName;
        return this.getId() + " name: " + this.getName();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }
}

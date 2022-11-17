package playlist_entities;

import Entities.Record;
import Entities.Song;
import java.util.ArrayList;

public class Playlist extends Record {
    private String name;
    private final int id;
    private int duration;
    private ArrayList<Song> contents;
    private final String owner;
    private String description;
    private enum Privacy{PRIVATE, FRIENDS, PUBLIC};
    private Privacy privacy;
    private int pic;

    /***
     * Default constructor for playlist
     *
     *
     */
    public Playlist(int id) {
        this.name = "";
        this.id = id;
        this.duration = 0;
        this.contents = new ArrayList<Song>();
        this.owner = "";
        this.description = "";
        this.privacy = Privacy.PRIVATE;
        this.pic = 0; //set to default
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
    public String setDuration(int duration) {
        this.duration = duration;
        return this.getId() + " duration: " + this.getDuration();
    }

    public String getOwner(){return this.owner;}
    public String getDescription(){return this.description;}
    public String setDescription(String description){
        this.description = description;
        return this.getId() + " description: " + this.getDescription();
    }
    public Privacy getPrivacy(){
        return this.privacy;
    }
    public String setPrivacy(Privacy privacy){
        this.privacy = privacy;
        return this.getId() + " privacy: " + this.getPrivacy();
    }
}

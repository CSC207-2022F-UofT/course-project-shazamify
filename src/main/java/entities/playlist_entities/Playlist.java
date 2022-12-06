package entities.playlist_entities;

import entities.Record;

import java.io.File;
import java.util.ArrayList;

public class Playlist implements Record {
    private final String owner;
    private final String id;
    private String name;
    private int duration;
    private ArrayList<String> contents;
    private String description;
    private Privacy privacy;

    /***
     * Default constructor for playlist
     *
     *
     */
    public Playlist(String id) {
        this.name = "";
        this.id = id;
        this.duration = 0;
        this.contents = new ArrayList<String>();
        this.owner = "";
        this.description = "";
        this.privacy = Privacy.PRIVATE;

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
    public String getId() {
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

    public String getArtist() {
        return this.owner;
    }

    public String getDescription() {
        return this.description;
    }

    public String setDescription(String description) {
        this.description = description;
        return this.getId() + " description: " + this.getDescription();
    }

    public Privacy getPrivacy() {
        return this.privacy;
    }

    public String setPrivacy(Privacy privacy) {
        this.privacy = privacy;
        return this.getId() + " privacy: " + this.getPrivacy();
    }

    public File getCover() {
        return null;
    }

    public ArrayList<String> getSongs() {
        return this.contents;
    }

    public Object setSongs(ArrayList<String> contents) {
        this.contents = contents;
        return null;
    }

    public boolean reOrderSongs(String songID, int ind) {
        if (this.contents.contains(songID) && ind < this.contents.size()) {
            this.deleteSong(songID);
            this.addSong(songID, ind);
            return true;
        } else {
            return false;
        }
    }

    public void deleteSong(String songID) {
        this.contents.remove(songID);
    }

    public boolean addSong(String songID) {
        if (this.contents.contains(songID)) {
            return false;
        } else {
            this.contents.add(songID);
            return true;
        }
    }

    public boolean addSong(String songID, int ind) {
        if (!(this.contents.contains(songID)) && ind < this.contents.size()) {
            this.contents.add(ind, songID);
            return true;
        } else {
            return false;
        }
    }


}

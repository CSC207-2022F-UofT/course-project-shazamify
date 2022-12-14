package entities.playlist_entities;

import entities.Record;

import java.io.File;
import java.util.ArrayList;

public class Playlist implements Record {
    private String owner;
    private String id;
    private String name;
    private int duration;
    private ArrayList<String> contents;
    private String description;
    private Privacy privacy;


    /**
     * Empty constructor necessary for MongoDB encoding
     */
    public Playlist() {

    }

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

    public String getOwner() {
        return owner;
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

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return this.owner;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Privacy getPrivacy() {
        return this.privacy;
    }

    public String setPrivacy(Privacy privacy) {
        this.privacy = privacy;
        return this.getId() + " privacy: " + this.getPrivacy();
    }

    public File getCover() {
//        TODO: need to find different implementation
//        SongDAOOutput songdaoout = new SongDAOOutputImpl();
//        String firstSongId = this.contents.get(0);
//        return new File(songdaoout.findById(firstSongId).get().getCover());
        return null;
    }

    public ArrayList<String> getSongs() {
        return this.contents;
    }

    public void setSongs(ArrayList<String> contents) {
        this.contents = contents;
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

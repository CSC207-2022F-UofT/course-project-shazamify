package entities.playlist_entities;

import entities.Record;
import entities.Song;

import java.io.File;
import java.util.ArrayList;

;

public class Playlist implements Record {
    private String name;

    private String id;
    private int duration;
    private ArrayList<Song> contents;
    private final String owner;
    private String description;
    private Privacy privacy;
    private int pic;

    /***
     * Default constructor for playlist
     *
     *
     */
    public Playlist(String id) {
        this.name = "";
        this.id = id;
        this.duration = 0;
        this.contents = new ArrayList<>();
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

    public String getArtist(){return this.owner;}
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
    public File getCover() {return null;}
    public ArrayList<Song> getSongs() {return this.contents;}
    public Object setSongs(ArrayList<Song> contents){this.contents = contents;
        return null;
    }
    public boolean reOrderSongs(Song song, int ind){
        if(this.contents.contains(song) && ind < this.contents.size()){
            this.deleteSong(song);
            this.addSong(song, ind);
            return true;
        }
        else{
            return false;
        }
    }

    public void deleteSong(Song song){
        if(this.contents.contains(song)){
            this.contents.remove(song);
        }
    }

    public boolean addSong(Song song){
        if (this.contents.contains(song)){
            return false;
        }
        else{
            this.contents.add(song);
            return true;
        }
    }

    public boolean addSong(Song song, int ind){
        if(!(this.contents.contains(song)) && ind < this.contents.size()){
            this.contents.add(ind, song);
            return true;
        }
        else{
            return false;
        }
    }


}

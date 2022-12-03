package entities;

import java.io.File;
import java.util.ArrayList;

/***
 * Abstract class for the Record containing the abstract methods for getting the attributes.
 */
public interface Record {
    String getName();

    String getId();

    int getDuration();

    File getCover();

    String getArtist();

    ArrayList<Song> getSongs();
}

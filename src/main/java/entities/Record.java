package entities;

import java.io.File;
import java.util.ArrayList;

/***
 * Interface for the Record containing the methods for getting the attributes.
 */
public interface Record {
    String getName();

    String getId();

    int getDuration();

    File getCover();

    String getArtist();

    ArrayList<String> getSongs();

}

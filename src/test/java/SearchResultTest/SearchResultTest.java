package SearchResultTest;

import abr.search_engine_abr.SearchEngineOutputBoundary;
import abr.search_engine_abr.SearchSongAbr;
import abr.search_engine_abr.SearchUserAbr;
import entities.Song;
import entities.user_entities.User;
import interface_adaptors.search_engine_ia.SearchEnginePresenter;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhaozs
 * @date 2022/11/22/9:45
 */
public class SearchResultTest {
    /***
     * Test the function of searching the user.
     */

    public static void main(String[] args) {
        SearchEngineOutputBoundary songOutputBoundary = new SearchEnginePresenter();
        SearchUserAbr searchUserAbr = new SearchUserAbr(songOutputBoundary);
        SearchSongAbr searchSongAbr = new SearchSongAbr(songOutputBoundary);
        List<User> userList = searchUserAbr.searchUsers("Angela");
        List<Song> songList = searchSongAbr.searchSongs("Hello");
//        assertEquals(1, userList.size());
//        assertEquals("Angela", userList.get(0).getUserName());
//        assertEquals(1, songList.size());
//        assertEquals("Hello", songList.get(0).getName());
        assert Objects.equals(userList.size(),1);
        assert Objects.equals(userList.get(0).getUserName(),"Angela");
        assert Objects.equals(songList.size(),1);
        assert Objects.equals(songList.get(0).getName(),"Hello");
    }
}

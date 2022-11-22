package abr.search_engine_abr;

import abr.search_engine_abr.SearchUserAbr;
import user.entities.User;

import java.util.List;
import java.util.Objects;

/**
 * @author Zhaozs
 * @date 2022/11/22/9:45
 */
@Test
public class SearchResultTest {
        public static void main(String[] args) {
            SearchUserAbr searchUserAbr=new SearchUserAbr();
            List<User> userList=searchUserAbr.searchUsers("Angela");
            assert Objects.equals(userList.size(),1);
            assert Objects.equals(userList.get(0).getUserName(),"Angela");
        }
}

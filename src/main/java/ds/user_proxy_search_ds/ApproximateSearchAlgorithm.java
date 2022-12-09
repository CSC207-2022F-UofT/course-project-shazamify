package ds.user_proxy_search_ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author David Li
 *
 * Math Reference: <a href="https://en.wikipedia.org/wiki/Levenshtein_distance">...</a>
 *
 */
public class ApproximateSearchAlgorithm {

    public static List<String> sortedByLevenshteinDistance(List<String> ids, String targetID){
        List<Integer> proxyScores = giveOutProxyScores(ids, targetID);

        Comparator<String> compare = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return proxyScores.get(ids.indexOf(o1)) - proxyScores.get(ids.indexOf(o2));
            }
        };

        ids.sort(compare);
        return ids;
    }


    /**
     * Will give out each ID's approximate score
     * @param ids the ID, ex. UserName
     * @return A map mapping from ID to its approximate score
     */
    public static List<Integer> giveOutProxyScores(List<String> ids, String targetID){

        List<Integer> proxyScores = new ArrayList<>();
        char[] string2 = targetID.toCharArray();

        for (String id: ids){
            char[] string1 = id.toCharArray();

            int proxyScore = getLevenshteinDistance(string1, string2);
            proxyScores.add(proxyScore);
        }

        return proxyScores;
    }



    private static int getLevenshteinDistance(char[] string1, char[] string2){
        int[][] LevenshteinMatrix = new int[string1.length + 1][string2.length + 1];
        LevenshteinMatrix[0][0] = 0;
        for (int i=0; i<= string1.length; i++){
            LevenshteinMatrix[i][0] = i;
        }
        for (int j=0; j<= string2.length; j++){
            LevenshteinMatrix[0][j] = j;
        }
        for (int i=1; i<= string1.length; i++){
            for (int j=1; j<= string2.length; j++){
                int move;
                if (string1[i - 1] == (string2[j - 1])){
                    move = 0;
                } else {
                    move = 1;
                }

                List<Integer> comparisonArray = new ArrayList<>();
                comparisonArray.add(LevenshteinMatrix[i-1][j]);
                comparisonArray.add(LevenshteinMatrix[i][j-1]);
                comparisonArray.add(LevenshteinMatrix[i-1][j-1]);

                int smallest = getSmallest(comparisonArray);

                LevenshteinMatrix[i][j] = smallest + move;
            }
        }

        return LevenshteinMatrix[string1.length][string2.length];
    }

    private static int getSmallest(List<Integer> comparisonArray){
        int smallest = 100;
        for (int i : comparisonArray){
            if (i < smallest){
                smallest = i;
            }
        }

        return smallest;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String a = "David";
        String b = "DavidLi";

        list.add(a);
        list.add(b);
        list.add("LiDavid");
        list.add("1111");

        List<String> score = sortedByLevenshteinDistance(list, "David");
        System.out.println(score);
    }
}

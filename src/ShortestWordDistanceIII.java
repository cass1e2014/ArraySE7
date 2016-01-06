import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now
 * word1 could be the same as word2.
 * 
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * word1 and word2 may be the same and they represent two individual words in
 * the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Given word1 = “makes”, word2 = “coding”, return 1. 
 * Given word1 = "makes", word2 = "makes", return 3.
 * 
 * 
 * @author cassie9082
 * 
 */
public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                List<Integer> pos = map.get(words[i]);
                pos.add(i);
                map.put(words[i], pos);
            }else{
                List<Integer> pos = new ArrayList<Integer>();
                pos.add(i);
                map.put(words[i], pos);
            }
        }
        
        int minDistance = Integer.MAX_VALUE;
        List<Integer> start = map.get(word1);
        List<Integer> end = map.get(word2);
        if(word1.equals(word2)){
            for(int i = 1; i < start.size(); i++){
                minDistance = Math.min(minDistance, Math.abs(start.get(i) - start.get(i-1)));
            }
        }else{
            for(int i : start){
                for(int j : end){
                    minDistance = Math.min(minDistance, Math.abs(i - j));
                }
            }
        }
        return minDistance;
    }
	
	//不用hashmap的做法
	//The key is we cannot update the two pointers simultaneously, if they are the same. 
	//We could update one, compare the distance, and then update the other. 
    public int shortestWordDistance2(String[] words, String word1, String word2) {
        int posA = -1;
        int posB = -1;
        int minDistance = Integer.MAX_VALUE;
         
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
             
            if (word.equals(word1)) {
                posA = i;
            } else if (word.equals(word2)) {
                posB = i;
            }
             
            if (posA != -1 && posB != -1 && posA != posB) {
                minDistance = Math.min(minDistance, Math.abs(posA - posB));
            }
             
            if (word1.equals(word2)) {
                posB = posA;
            }
        }
         
        return minDistance;
    }

}

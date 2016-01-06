/**
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3. 
 * Given word1 = "makes", word2 = "coding", return 1.
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2
 * are both in the list.
 * 
 * @author cassie9082
 * 
 */
public class ShortestWordDistance {
	public static int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0){
        	return 0;
        }
        
        int idx1 = -1;
        int idx2 = -1;
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
        	if(word1.equals(words[i])){
        		idx1 = i;
        		if(idx2 != -1){
        			distance = Math.min(distance,  idx1-idx2);
        		}
        	}
        	
        	if(word2.equals(words[i])){
        		idx2 = i;
        		if(idx1 != -1){
        			distance = Math.min(distance, idx2-idx1);
        		}
        	}
        }
        return distance;
    }
	
	public static void main(String[] args){
		String[] strs = {"practice","makes","perfect","coding","makes"};
		System.out.println(shortestDistance(strs, "coding", "practice"));
	}
}

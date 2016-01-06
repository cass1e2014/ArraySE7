import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you
 * are given the list of words and your method will be called repeatedly many
 * times with different parameters. How would you optimize it?
 * 
 * Design a class which receives a list of words in the constructor, and
 * implements a method that takes two words word1 and word2 and return the
 * shortest distance between these two words in the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3. 
 * Given word1 = "makes", word2 = "coding", return 1.
 * 
 * @author cassie9082
 * 
 */
public class ShortestWordDistanceII {
	/*
	 * if we can put the words into a hash map, we don't have to iterate over
	 * the array again and again. It is only a one time cost.
	 */
	private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

	public ShortestWordDistanceII(String[] words) {
		fill(words);
	}

	public void fill(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				List<Integer> pos = map.get(words[i]);
				pos.add(i);
				map.put(words[i], pos);
			} else {
				List<Integer> pos = new ArrayList<Integer>();
				pos.add(i);
				map.put(words[i], pos);// map里放的是string和存有位置的list
			}
		}
	}

	public int shortest(String word1, String word2) {
		int minDistance = Integer.MAX_VALUE;
		List<Integer> start = map.get(word1);
		List<Integer> end = map.get(word2);

		for (int i : start) {
			for (int j : end) {
				minDistance = Math.min(minDistance, Math.abs(i - j));
			}
		}

		return minDistance;
	}
}

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 * 
 * @author cassie9082
 * 
 */
public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null)		return false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			if (!map.containsKey(val)) {
				map.put(val, i);
			} else {
				if (i - map.get(val) <= k) {
					return true;
				} else {
					map.put(val, i);//update最新的index，例如[1, 0, 1, 1]  k=1
				}
			}
		}
		return false;
	}
}

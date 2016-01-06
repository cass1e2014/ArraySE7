import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * 
 * @author cassie9082
 * 
 */
public class MajorityElement {
	//space O(n)
	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		int len = nums.length;
		Iterator itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry pair = (Map.Entry) itr.next();
			int key = (int) pair.getKey();
			int value = (int) pair.getValue();
			if (value > len / 2) {
				return key;
			}
		}
		return 0;
	}
	
	//超过一半的数只有可能有一个
	public static int majorityElement2(int[] nums) {
		int candidate = nums[0], cnt = 0;
        for(int i = 1; i < nums.length; i++){
            if(candidate == nums[i]){
                cnt++;
            } else if(cnt==0){
                candidate = nums[i];
            } else {
                cnt--;
            }
        }
        return candidate;
    }

	public static void main(String[] args){
		int[] nums = {1, 3, 3, 2, 2, 2, 4, 4, 4, 4, 4, 4};
		System.out.println(majorityElement2(nums));
	}
}

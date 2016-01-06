import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * @author cassie9082
 * 
 */
public class SummaryRanges {
	//Time O(n), Space O(n)
	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if(nums == null || nums.length == 0){
			return result;
		}
		
		int start = 0;
		while(start < nums.length){
			int range = 1;
			while(start + range < nums.length && nums[start+range] - nums[start] == range){
				range ++;
			}
			StringBuilder tmp = new StringBuilder();
			tmp.append(nums[start]);
			if(range > 1){
				tmp.append("->");
				tmp.append(nums[start+range-1]);
			}
			result.add(tmp.toString());
			start = start + range;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 4, 5, 7};
		System.out.println(summaryRanges(nums));
	}

}

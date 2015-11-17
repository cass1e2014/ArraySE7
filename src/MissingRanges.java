import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [lower, upper]
 * inclusive, return its missing ranges.
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2",
 * "4->49", "51->74", "76->99"].
 * 
 * @author cassie9082
 * 
 */
public class MissingRanges {
	// take care of the corner cases
	// --if the array is empty, the missing range should be from lower to upper,inclusive
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			outputToResult(lower, upper, result);
			return result;
		}

		// 比nums[0]小但比lower大
		if (nums[0] - lower > 0) {
			outputToResult(lower, nums[0] - 1, result);
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] > 1) {
				outputToResult(nums[i - 1] + 1, nums[i] - 1, result);
			}
		}

		// 比nums[nums.length - 1]大但是比upper小
		if (upper - nums[nums.length - 1] > 0) {
			outputToResult(nums[nums.length - 1] + 1, upper, result);
		}
		return result;
	}

	public void outputToResult(int start, int end, List<String> result) {
		StringBuffer sb = new StringBuffer();
		if (start == end) {
			sb.append(start);
		} else {
			sb.append(start).append("->").append(end);
		}
		result.add(sb.toString());
	}
}

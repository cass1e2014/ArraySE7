import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * 
 * @author cassie9082
 * 
 */
public class MajorityElementII {
	/*
	 * Boyer-Moore Majority Vote algorithm 数组中至多可能会有2个出现次数超过 ⌊ n/3 ⌋ 的众数
	 * 
	 * The essential concepts is you keep a counter for the majority number X.
	 * If you find a number Y that is not X, the current counter should deduce
	 * 1. The reason is that if there is 5 X and 4 Y, there would be one (5-4)
	 * more X than Y. This could be explained as "4 X being paired out by 4 Y".
	 */
	// 超过n/3的数最多可能有两个，所以我们要记录出现最多的两个数。
	//同样的两个candidate和对应的两个counter，
	//如果遍历时，某个候选数和到当前数相等，则给相应计数器加1。
	//如果某个计数器为0了，则将当前数替换相应的候选数，并将计数器初始化为1。
	//如果两个计数器都不为0，则两个计数器都被抵消掉1。
	//最后我们还要遍历一遍数组，确定这两个出现最多的数，是否都是众数。
	//最后的最后还要看两个counter是否分别大于length/3，是的话加入到list中去。
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		if (nums.length == 1) {
			result.add(nums[0]);
			return result;
		}

		int candidate1 = nums[0];
		int candidate2 = 0;

		int count1 = 1;
		int count2 = 0;

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (candidate1 == num) {
				count1++;
			} else if (candidate2 == num) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = num;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;

		for (int num : nums) {
			if (num == candidate1) {
				count1++;
			} else if (num == candidate2) {
				count2++;
			}
		}

		if (count1 > nums.length / 3) {
			result.add(candidate1);
		}

		if (count2 > nums.length / 3) {
			result.add(candidate2);
		}

		return result;
	}
}

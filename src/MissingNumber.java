/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 * 
 * For example, Given nums = [0, 1, 3] return 2.
 * 
 * Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 * 
 * 
 * @author cassie9082
 * 
 */
public class MissingNumber {
	public int missingNumber(int[] nums) {
		// Corner Case**
		/*
		 * if the array after the bucketing is [0, 1, 2], then the missing
		 * number is 3. That is because we have N numbers ranging from 0 to N,
		 * the last bucket stores N - 1. So we need to return nums.length.
		 */
		if (nums == null || nums.length == 0) {
			return 0;
		}

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (i != num && num < nums.length && nums[num] != num) {
				swap(nums, i, num);
				i--;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i) {
				return i;
			}
		}
		return nums.length;
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}

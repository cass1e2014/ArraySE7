import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 */
public class MedianOfTwoSortedArray {
	/**
	 * 有序数组中位数
	 * 时间O(log(m+n)), 空间O(1)
	 * 分治法， divide and conquer
	 * 当n为奇数时，搜寻第(n/2+1)个元素，当n为偶数时，搜寻第(n/2+1)和第(n/2)个元素，然后取他们的均值。
	 * 我们可以把这题抽象为“搜索两个有序序列的第k个元素”。如果我们解决了这个k元素问题，那中位数不过是k的取值不同罢了。
	 * 
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return 0.0;
		}

		int n1 = nums1.length;
		int n2 = nums2.length;
		// 奇数
		if ((n1 + n2) % 2 == 1) {
			return findMedianHelper(nums1, nums2, (n1 + n2) / 2 + 1);
		} else {
			return (findMedianHelper(nums1, nums2, (n1 + n2) / 2) + findMedianHelper(
					nums1, nums2, (n1 + n2) / 2 + 1)) / 2;
		}
	}

	private double findMedianHelper(int[] nums1, int[] nums2, int k) {
		if (nums1 == null || nums1.length == 0) {
			return nums2[k - 1];
		}

		if (nums2 == null || nums2.length == 0) {
			return nums1[k - 1];
		}

		if (k == 1) {
			return Math.min(nums1[0], nums2[0]);
		}
		int n1 = nums1.length;
		int n2 = nums2.length;

		if (nums1[n1 / 2] > nums2[n2 / 2]) {
			// 当前中位数取大了,drop nums1[]的后半段
			if ((n1 / 2 + n2 / 2 + 1) >= k) {
				return findMedianHelper(Arrays.copyOfRange(nums1, 0, n1 / 2),nums2, k);
			} else {
				return findMedianHelper(nums1,Arrays.copyOfRange(nums2, n2 / 2 + 1, n2), k - (n2 / 2 + 1));
			}
		} else {
			if ((n1 / 2 + n2 / 2 + 1) >= k) {
				return findMedianHelper(nums1,Arrays.copyOfRange(nums2, 0, n2 / 2), k);
			} else {
				return findMedianHelper(Arrays.copyOfRange(nums1, n1 / 2 + 1, n1), nums2, k - (n1 / 2 + 1));
			}
		}

	}

}

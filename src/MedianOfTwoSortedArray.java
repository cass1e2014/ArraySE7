import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 */
public class MedianOfTwoSortedArray {

	/*
	 * An initial thought was firstly merge the two arrays, 
	 * then median is the number on A.length + B.length - 1 / 2. 
	 * However, merging will take O(m + n) time, so it is binary search
	 * Definition of the median of a sorted array-- The return number is double.
	 * So if the array length is even, e.g. 1, 2, 3, 4. The median is the
	 * average of 2 and 3, i.e., 2 + 3 / 2 = 2.5
	 * ---------------------------------------------------------
	 * sec1:a0,a1,a2,.....,am/2, sec2:am/2+1,.....am-2,am-1
	 * sec3:b0,b1,b2,.....,bn/2, sec4:bn/2+1,.....bn-2,bn-1
	 * 丢弃哪部分取决于：(m/2+n/2) ? k      A[m/2] ? B[n/2]
	 * 
	 * If (m/2+n/2+1) > k && am/2 > bn/2 , drop Section 2
	 * If (m/2+n/2+1) > k && am/2 < bn/2 , drop Section 4
	 * If (m/2+n/2+1) < k && am/2 > bn/2 ,  drop Section 3
	 * If (m/2+n/2+1) < k && am/2 < bn/2 ,  drop Section 1
	 * 丢弃最大中位数的右区间，或者丢弃最小中位数的左区间
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

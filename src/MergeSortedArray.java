/**
 * Merge Sorted Array (4/28) Given two sorted integer arrays nums1 and nums2,
 * merge nums2 into nums1 as one sorted array. 
 * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional
 * elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are nums1 and nums2 respectively. 
 * nums1[]: {1, 3, 5, 8}; nums2[]: {2, 4, 9}; --> nums1[]: {1, 2, 3, 4, 5, 9, 8};
 */
public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (nums1 == null || nums2 == null || nums1.length == 0
				|| nums2.length == 0) {
			return;
		}

		int k = m + n - 1;
		int i = m - 1;
		int j = n - 1;

		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				i--;
				k--;
			} else {
				nums1[k] = nums2[j];
				j--;
				k--;
			}
		}

		while (j >= 0) {
			nums1[k] = nums2[j];
			k--;
			j--;
		}

		while (i >= 0) {
			nums1[k] = nums1[i];
			k--;
			i--;
		}
	}

	public static void main(String[] args) {
		int[] A = new int[7];
		A[0] = 1;
		A[1] = 3;
		A[2] = 5;
		A[3] = 8;
		int[] B = { 2, 4, 9 };
		int m = 4;
		int n = 3;
		merge(A, m, B, n);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
}

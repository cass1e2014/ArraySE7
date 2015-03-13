/**
 * Median of Two Sorted Array (4/27)
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 * 同時也是另一題: "找到兩個 sorted array 中的第 k 個數"
 * 
 */
public class MedianOfTwoSortedArray {

	public static double findMedianSortedArrays(int[] A, int[] B) {
		int len = A.length + B.length;
		// 求median的话，如果A,B之和是偶数，则取中间两个数之和/2， 如果A,B之和是奇数， 则取中间的数即为median
		if (len % 2 == 0) {
			return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0,
					len / 2 + 1)) / 2.0;
		} else {
			return findKth(A, 0, B, 0, len / 2 + 1);
		}
	}

	public static int findKth(int[] A, int pointerA, int[] B, int pointerB,
			int k) {
		// 如果A指针移动到超出A[]的长度
		System.out.println("k is -- " + k + " , pointerA is -- " + pointerA + " , pointerB is -- " + pointerB);
		if (pointerA >= A.length) {
			System.out.println("Enter pointerA >= A.length, A.length is -- " + A.length);
			return B[pointerB + k - 1]; //-1是减去pointerB本身，array中index比实际减1
		}

		// 如果B指针移动到超出B[]的长度
		if (pointerB >= B.length) {
			System.out.println("Enter pointerB >= B.length, B.length is -- " + B.length);
			return A[pointerA + k - 1];
		}

		// 当recursion做到k只有1的时候，取最小值
		if (k == 1) {
			return Math.min(A[pointerA], B[pointerB]);
		}

		int aKey = pointerA + k / 2 - 1 < A.length ? A[pointerA + k / 2 - 1]
				: Integer.MAX_VALUE;
		System.out.println("aKey is -- " + aKey);
		int bKey = pointerB + k / 2 - 1 < B.length ? B[pointerB + k / 2 - 1]
				: Integer.MAX_VALUE;
		System.out.println("bKey is -- " + bKey);

		/**
		 * 之前的pointerA停在了pointerA + k/2 - 1的位置上，所以下一个recursion的起始位置是pointerA +
		 * k/2 因为aKey < bKey, 所以aKey之前的数不需要再考虑。A[]的起点为pointerA + k/2,
		 * B[]仍在pointerB处 k/2为不用考虑的数目（因为k - k/2)
		 */
		if (aKey < bKey) {
			return findKth(A, pointerA + k / 2, B, pointerB, k - k / 2);
		} else {
			return findKth(A, pointerA, B, pointerB + k / 2, k - k / 2);
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 7, 9};
		int[] B = { 2, 4, 6};
		double result = findMedianSortedArrays(A, B);
	//	int res = linearSeachK(A, B, 5);
	//	System.out.println(res);
		System.out.println(result);
	}

	// linear method: O(m+n)
	public static int linearSeachK(int[] A, int[] B, int k) {
		int pa = 0;
		int pb = 0;

		if (A == null || A.length == 0) {
			return B[k - 1];
		}

		if (B == null || B.length == 0) {
			return A[k - 1];
		}
		for (int i = 0; i < k - 1; i++) {
			if (pa < A.length && A[pa] < B[pb]) {
				pa++;
			} else if (pb < B.length && A[pa] >= B[pb]) {
				pb++;
			}

			if (pa == A.length) {
				return B[k - A.length - 1];
			} else if (pb == B.length) {
				return A[k - B.length - 1];
			}

		}
		return Math.min(A[pa], B[pb]);

	}
}

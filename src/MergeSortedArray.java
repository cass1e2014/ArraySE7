/**
 * Merge Sorted Array (4/28)
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 * A[]: {1, 3, 5, 8}; B[]: {2, 4, 9}; --> A[]: {1, 2, 3, 4, 5, 9, 8};
 */
public class MergeSortedArray {
	
	public static void merge(int[] A, int m, int[] B, int n){
		if(A == null || B == null){
			return;
		}
		
		int index = m + n;
		while(m > 0 && n > 0){
			if(A[m - 1] > B[n - 1]){
				A[--index] = A[--m];//比较A[]和B[]中的最后一个元素，将较大的填入A[m+n-1]中
			}else{
				A[--index] = B[--n];
			}
		}
		
		//如果B比A长
		while(n > 0){
			A[--index] = B[--n];
		}
	}
	
	public static void main(String[] args) {
		int[] A = new int[7];
		A[0] = 1;
		A[1] = 3;
		A[2] = 5;
		A[3] = 8;
		int[] B = {2, 4, 9};
		int m = 4;
		int n = 3;
		merge(A, m, B, n);
		for(int i = 0; i < A.length; i++){
			System.out.println(A[i]);
		}
	}
}		

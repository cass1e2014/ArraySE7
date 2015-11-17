/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5
 * ] ]
 **/

public class SpiralMatrixII {
	//Time O(N^2) Space O(N^2)
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		if (n == 0) {
			return result;
		}

		int k = 1;
		int top = 0;
		int bottom = n - 1;
		int left = 0;
		int right = n - 1;

		while (left < right && top < bottom) {
			for (int i = left; i < right; i++) {
				result[top][i] = k++;
			}
			for (int i = top; i < bottom; i++) {
				result[i][right] = k++;
			}
			for (int i = right; i > left; i--) {
				result[bottom][i] = k++;
			}
			for (int i = bottom; i > top; i--) {
				result[i][left] = k++;
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		if (n % 2 != 0) {
			result[n / 2][n / 2] = k;
		}
		return result;
	}
}

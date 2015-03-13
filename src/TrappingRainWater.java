/**
 * Trapping Rain Water (4/28)
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * 下面我们说说优化的算法。这种方法是基于动态规划的，基本思路就是维护一个长度为n的数组，
 * 进行两次扫描，一次从左往右，一次从右往左。第一次扫描的时候维护对于每一个bar左边最大的高度是多少，
 * 存入数组对应元素中，第二次扫描的时候维护右边最大的高度，
 * 并且比较将左边和右边小的最大高度（我们成为瓶颈）存入数组对应元素中。
 * 这样两遍扫描之后就可以得到每一个bar能承受的最大水量，从而累加得出结果。
 * 这个方法只需要两次扫描，所以时间复杂度是O(2*n)=O(n)。空间上需要一个长度为n的数组，复杂度是O(n)。
 * 類似 Candy 的作法
 * 
 * 	   A[]: 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
 *  left[]: 0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3
 * right[]: 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0

 */
public class TrappingRainWater {

	public static int trap(int[] A){
		if(A == null || A.length == 0){
			return 0;
		}
		
		//左邊最高
		int[] left = new int[A.length];
		int max = 0;
		for(int i = 0; i < A.length; i++){
			left[i] = max;
			max = Math.max(A[i], max);//update maximum
		}
		
		//右邊最高
		int[] right = new int[A.length];
		max = 0;
		for(int i = A.length - 1; i >= 0 ; i--){
			right[i] = max;
			max = Math.max(A[i], max);
		}
		
		//如果左右兩邊的低邊高於自己, 代表能儲水, 所儲的水即為低邊跟自己的差值
		int result = 0;
		for(int i = 1; i < A.length -1; i++){
			int temp = Math.min(left[i], right[i]);
			if(temp - A[i] > 0) {
				result += temp - A[i];
			}
		}
		return result;
	}
	

	public static void main(String[] args) {
		int[] A = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int res = trap(A);
		System.out.println(res);
	}
}

/**
 * Max SubArray (4/27)
 * 如果之前SubArray的总体和大于0的话，我们可以认为其对后续数字是有贡献的。这种情况下我们选择加入之前的SubArray
 * 如果之前SubArray的总体和为0或者小于0的话，我们可以认为其对后续数字是没有贡献，甚至是有害的（小于0时）
 * 这种情况下我们只能选择以这个数字开始，另起一个SubArray
 * sum记录之前SubArray的和，max用来返回最大值
 * 当sum的值大于max时，说明发现和更大的SubArray序列，此时更新max的值
 */
public class MaxSubArray {
	
	public static int maxSubArray(int[] A){
		//空集情况
		if(A == null || A.length < 1){
			return 0;
		}
		
		int max = Integer.MIN_VALUE;	
		int sum = 0;
		for(int num : A){
			sum += num;
			max = Math.max(sum, max);
			sum = Math.max(sum, 0); 
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int result = maxSubArray(A);
		System.out.println(result);
	}

}

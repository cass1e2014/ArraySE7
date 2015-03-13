import java.util.Arrays;

/**
 * Candy (4/26)
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * 1. Each child must have at least one candy
 * 2. Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * Example: Input = [1,2,2], Output = 4
 */

public class Candy {

	public static int candy(int[] ratings) {
		int[] candies = new int[ratings.length];
		Arrays.fill(candies, 1);
		
		//从左往右比较
		for(int i = 1; i < ratings.length; i++){
			if(ratings[i] > ratings[i - 1]){
				candies[i] = candies[i - 1] + 1;
			}
		}
		
		/**
		 * 再从右往左比较（注意相等的情况）
		 * 当左边的比右边的大 && 在candies数列中左边的数却比右边小或者等于的情况下，左边 = 右边 + 1；
		 */
		for(int i = ratings.length - 2; i >= 0; i--){
			if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]){
				candies[i] = candies[i + 1] + 1;
			}
		}
		
		//再for loop走一遍算candies总数是多少
		int sum = 0; 
		for(int i = 0; i < candies.length; i++){
			sum += candies[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] ratings = {1, 2, 3, 1};
		int result = candy(ratings);
		System.out.println(result);

	}
	
}

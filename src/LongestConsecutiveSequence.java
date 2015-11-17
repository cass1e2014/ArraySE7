import java.util.HashSet;

/**
 * Longest Consecutive Sequence (4/27)
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example, Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 *
 * 用Hashset, 依照 set.contains(i - 1) 跟 set.contains(i + 1) 增加長度
 *
 * Time ~O(N), Space ~O(N)
 */
public class LongestConsecutiveSequence {
	
	public static int longestConsecutive(int[] num){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i : num){
			set.add(i);
		}
		
		int maxLength = 0;
		for(int i : num){
			set.remove(i);
			int length = 1;//length储存的是当前这个数字前后左右连续的情况。所以默认是1，即为本身
			int left = i;
			int right = i;
			
			//若i = 400， 则看有set里有没有399， 398， 397。。。
			while(set.contains(left - 1)){
				left --;
				length ++;
				set.remove(left);
			}
			
			//若i = 400， 则看set里有没有401， 402， 403。。。
			while(set.contains(right + 1)){
				right ++;
				length ++;
				set.remove(right);
			}
			
			maxLength = Math.max(maxLength, length);
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		int[] num = {400, 1, 200, 3, 4, 2};
		int result = longestConsecutive(num);
		System.out.println(result);
	}

}

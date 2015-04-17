import java.util.Arrays;


/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * 
 * 借鉴了Counting sort中的方法
 * 既然不能用额外空间，那就只有利用数组本身
 * 利用数组的index来作为数字本身的索引，把正数按照递增顺序依次放到数组中。
 * 即让A[0]=1, A[1]=2, A[2]=3, ... , 这样一来，最后如果哪个数组元素违反了A[i]=i+1
 * 即说明i+1就是我们要求的第一个缺失的正数。对于那些不在范围内的数字，我们可以直接跳过，
 * 比如说负数，0，或者超过数组长度的正数，这些都不会是我们的答案
 * 
 */
public class FirstMissingPositive {

	public static void main(String[] args) {
		FirstMissingPositive f = new FirstMissingPositive();
		int[] A = {3, 4, -1, 1};
		
		System.out.println(f.firstMissingPositive(A));

	}
	
	public int firstMissingPositive(int[] A){
		if(A == null){
			return 0;
		}
		
		for(int i = 0; i < A.length; i++){
			if(A[i] <= A.length && A[i] > 0 && A[A[i]-1] != A[i]){
//				System.out.println("i = " + i + " , A[A[i]-1] = " + A[A[i]-1]);
				int temp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = temp;
//				System.out.println("After i--, i = " + i);
//				System.out.println("After exchange, Array A is: " + Arrays.toString(A));
  			}
		}
		
	    for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;  
            }
        }
	    
        return A.length + 1;		
	}

	
}

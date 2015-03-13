import java.util.Arrays;

 /**
  * Next Permutation (4/28)
  * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
  * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
  * The replacement must be in-place, do not allocate extra memory.
  * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
  * 1,2,3 → 1,3,2
  * 3,2,1 → 1,2,3
  * 1,1,5 → 1,5,1
  * 
  * 这道题是给定一个数组和一个排列，求下一个排列。算法上其实没有什么特别的地方，
  * 主要的问题是经常不是一见到这个题就能马上理清思路。下面我们用一个例子来说明，
  * 比如排列是(2,3,6,5,4,1)，求下一个排列的基本步骤是这样：
  * 1) 先从后往前找到第一个不是依次增长的数，记录下位置p。比如例子中的3，对应的位置是1;
  * 2) 接下来分两种情况：
  *		(1) 如果上面的数字都是依次增长的，那么说明这是最后一个排列，下一个就是第一个，
  * 其实把所有数字反转过来即可(比如(6,5,4,3,2,1)下一个是(1,2,3,4,5,6));
  * 	(2) 否则，如果p存在，从p开始往后找，找到下一个数就比p对应的数小的数字，然后两个调换位置，
  * 比如例子中的4。调换位置后得到(2,4,6,5,3,1)。最后把p之后的所有数字倒序，比如例子中得到(2,4,1,3,5,6),
  * 这个即是要求的下一个排列。
  */
public class NextPermutation {

	public void nextPermutation(int[] num){
		if(num == null){
			return;
		}
		
		int edge = -1;
		
		//先从后往前找到第一个不是依次增长的数，记录下位置p
		for(int i = num.length - 2; i >= 0; i--){
			if(num[i] < num[i + 1]){
				edge = i;
				break;
			}
		}
		
		if(edge > -1){
			for(int i = edge + 1; i < num.length; i++){
				//从下降沿开始往后找出替换它的元素。（就是第一个比它小的前一个元素）
				if(num[edge] >= num[i]){
					nextPermutationSwap(num, edge, i - 1);
					break;
				}
				
				//当后面没有比edge小的数，则停在最后一位上，swap edge和最后一位
				if(i == num.length - 1){
					nextPermutationSwap(num, edge, i);
					break;
				}
			}
		}
		
		//反转后面所有元素，让他从小到大sorted（因为之前是从大到小sorted的）  
		//for(int i = edge + 1, j = num.length - 1; i <j;  i ++, j--)
		//中间只是控制次数，2种写法都可以。i < j， 会停在i = j的时候，i = j的时候实际也不用做swap
		for(int i = edge + 1, j = num.length - 1; i <= edge + (num.length - edge - 1) / 2;  i ++, j--){
			nextPermutationSwap(num, i, j);
		}
	}
	
	//swap
	public void nextPermutationSwap(int[] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] num = {2, 3, 6, 5, 4, 1};
		NextPermutation np = new NextPermutation();
		np.nextPermutation(num);
		System.out.println(Arrays.toString(num));

	}

}

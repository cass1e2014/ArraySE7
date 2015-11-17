/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, 
 * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Related problem: Reverse Words in a String II
 * 
 * @author cassie9082
 * 
 */
public class RotateArray {
    //Time O(n), Space O(1)
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reversal(nums, 0, nums.length - k - 1);
        reversal(nums, nums.length - k, nums.length - 1);
        reversal(nums, 0, nums.length - 1);
    }
    
    private void reversal(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }
}

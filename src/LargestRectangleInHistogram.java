import java.util.Stack;


/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * Given height = [2,1,5,6,2,3], return 10.
 * 
 * 
 * 
 */

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        int[] height = {2, 1, 5, 6, 2, 3};
        System.out.println(l.largestRectangleArea(height));
	}
	
	public int largestRectangleArea(int[] height){
		if(height == null|| height.length == 0){
			return 0;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for(int i = 0; i <= height.length; i ++){
			int curt = (i == height.length) ? -1 : height[i];
			System.out.println("when i = " + i + ", curt = " + curt);
			while(!stack.isEmpty() && curt <= height[stack.peek()]){
				int h = height[stack.pop()];
				System.out.println("h = " + h);
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				System.out.println("w = " + w);
				max = Math.max(max, h*w);
				System.out.println("max = " + max);
			}
			stack.push(i);
			System.out.println("stack.push(i): " + i);
		}
		return max;
	}

}

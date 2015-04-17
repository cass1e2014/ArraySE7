import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram. Given height = [2,1,5,6,2,3], return 10.
 * 
 * 
 * 首先，如果栈是空的，那么索引i入栈。那么第一个i=0就进去吧。注意栈内保存的是索引，不是高度。然后i++。
 * 然后继续，当i=1的时候，发现h[i]小于了栈内的元素，于是出栈。（由此可以想到，哦，看来stack里面只存放单调递增的索引）
 * 这时候stack为空，所以面积的计算是h[t] * i.t是刚刚弹出的stack顶元素。也就是蓝色部分的面积。
 * 
 * 继续。这时候stack为空了，继续入栈。注意到只要是连续递增的序列，我们都要keep pushing，直到我们遇到了i=4，h[i]=2小于了栈顶的元素。
 * 这时候开始计算矩形面积。首先弹出栈顶元素，t=3。即下图绿色部分。
 * 接下来注意到栈顶的（索引指向的）元素还是大于当前i指向的元素，于是出栈，并继续计算面积，桃红色部分。
 * 最后，栈顶的（索引指向的）元素大于了当前i指向的元素，循环继续，入栈并推动i前进。直到我们再次遇到下降的元素，也就是我们最后人为添加的dummy元素0.
 * 同理，我们计算栈内的面积。由于当前i是最小元素，所以所有的栈内元素都要被弹出并参与面积计算。 注意我们在计算面积的时候已经更新过了maxArea。
 */

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
		int[] height = { 2, 1, 5, 6, 2, 3 };
		System.out.println(l.largestRectangleArea(height));
	}

	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>(); // 栈内保存都是index不是高度，stack里面只存放单调递增的索引
		int max = 0;
		for (int i = 0; i <= height.length; i++) {
			int currentHeight = (i == height.length) ? -1 : height[i];
			System.out.println("when i = " + i + ", curt = " + currentHeight);
			// 注意到只要是连续递增的序列，我们都要keep pushing，直到我们遇到了i=4，h[i]=2小于了栈顶的元素。
			while (!stack.isEmpty() && currentHeight <= height[stack.peek()]) {
				int h = height[stack.pop()];
//				System.out.println("h = " + h);
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
//				System.out.println("w = " + w);
				max = Math.max(max, h * w);
//				System.out.println("max = " + max);
			}
			stack.push(i);
//			System.out.println("stack.push(i): " + i);
		}
		return max;
	}

}

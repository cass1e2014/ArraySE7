import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Merge Intervals (4/27)
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

public class MergeIntervals {

	//build comparator, implement compare method!!! Anonymous class
	private Comparator<Interval> mergeComparator = new Comparator<Interval>(){
		public int compare(Interval a, Interval b){
			return a.start - b.start;
		}
	};
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals){
		ArrayList<Interval> result = new ArrayList<Interval>();
		//空集情况
		if(intervals == null || intervals.size()<= 1){
			return intervals;
		}
		
		//ArrayList用的较多，括号内第一格放AL，第二格放comparator
		Collections.sort(intervals, mergeComparator);
		
		/**
		 * 所以通过Collections.sort后，就是按照start的大小排列了
		 * 接下来讨论overlapping的情况，比较前一个的end和现在的那个的start的大小
		 */
		Interval last = intervals.get(0);
		for(int i = 0; i < intervals.size(); i++){
			Interval cur = intervals.get(i);
			if(last.end >= cur.start){
				last.end = Math.max(last.end, cur.end);
			}else{
				result.add(last);
				last = cur;
			}
		} 
		result.add(last);//不要忘记把最后一个interval加到AL中
		return result;
	}
	
	
	
	public static void main(String[] args) {
		Interval interval1 = new Interval(1, 3);
		Interval interval2 = new Interval(2, 6);
		Interval interval3 = new Interval(15, 18);
		Interval interval4 = new Interval(8, 10);
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		
		MergeIntervals mi = new MergeIntervals();
		ArrayList<Interval> res = mi.merge(intervals);
		for(Interval i : res){
			System.out.println(i);
		}
	}

}


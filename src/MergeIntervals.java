import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals (4/27)
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1){
            return intervals;
        }
        
        List<Interval> result = new ArrayList<Interval>();
        
        //把所有的interval按start point大小排好
        Collections.sort(intervals, intervalComparator);
        Interval last = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(last.end >= current.start){
                last.end = Math.max(last.end, current.end);
            }else{
                result.add(last);
                last = current;
            }
        }
        //list中的最后一个interval不要忘记加到结果中去
        result.add(last);
        return result;
    }
    
    public Comparator<Interval> intervalComparator = new Comparator<Interval>(){
      public int compare(Interval a, Interval b){
          return a.start - b.start;
      }  
    };
	
	
	
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
		List<Interval> res = mi.merge(intervals);
		for(Interval i : res){
			System.out.println(i);
		}
	}

}


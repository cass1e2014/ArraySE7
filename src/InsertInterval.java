import java.util.ArrayList;
import java.util.List;

/**
 * You may assume that the intervals were initially sorted according to their start times.
 * Insert Interval (4/26)
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

	public static List<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        if(newInterval == null){
            return intervals;
        }
        
        int insertPosition = 0;
        for(Interval interval : intervals){
            if(interval.end < newInterval.start){
                result.add(interval);
                insertPosition ++;
            }else if(interval.start > newInterval.end){
                result.add(interval);
            }else{
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        result.add(insertPosition, newInterval);
        return result;
	}
	
	
	public static void main(String[] args) {
		Interval interval1 = new Interval(1, 3);
		Interval interval2 = new Interval(6, 9);
		Interval newInterval = new Interval(2, 5);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(interval1);
		intervals.add(interval2);
		List<Interval> result = insert(intervals, newInterval);
		for(Interval item : result){
			System.out.println(item);
		}
	}

}


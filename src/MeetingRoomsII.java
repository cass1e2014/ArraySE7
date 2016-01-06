import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * For example, 
 * Given [[0, 30],[5, 10],[15, 20]], 
 * return 2.
 * 
 * @author cassie9082
 * 
 */
public class MeetingRoomsII {
    //需要一个pq来放interval.end
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        
        Arrays.sort(intervals, intervalComparator);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int numOfRooms = 1;
        
        pq.offer(intervals[0].end);
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < pq.peek()){
                numOfRooms ++;
                pq.offer(intervals[i].end); //把每个结束时间点看做一个房间，在pq里排着等被选
            }else{
                pq.poll();
                pq.offer(intervals[i].end);
            }
        }
        return numOfRooms;
    }
    
    public Comparator<Interval> intervalComparator = new Comparator<Interval>(){
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    };
}

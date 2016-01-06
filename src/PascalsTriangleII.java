import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * @author cassie9082
 * 
 * 不生成全部的 Triangle，只用另一个 List 记录 previous row
 * Time: O(n)
 * Space: o(n)
 * 
 */
public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = null;
		List<Integer> prev = null;
	
		//input:0, output:[], expected:[1], so i needs to be <= rowIndex
		for(int i = 0; i <= rowIndex; i++){
			list = new ArrayList<Integer>();
			for(int j = 0; j <= i; j++){
				if(j == 0 || i == j){
					list.add(1);
				}else{
					list.add(prev.get(j - 1) + prev.get(j));
				}
			}
			prev = new ArrayList<Integer>(list);
		}
		return list;	}
}

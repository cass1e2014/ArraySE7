import java.util.ArrayList;
import java.util.List;

/*
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * 
 * （杨辉三角）
 */

/*
 * 每一行的第一个或者最后一个总是list.add(1)，
 * 第一个是第一个col，最后一个是当row=col时，
 * Time: O(n)
 */
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> listSet = new ArrayList<List<Integer>>();
		for(int i= 0; i < numRows; i++){
			List<Integer> list = new ArrayList<Integer>();
			for(int j = 0; j < i; j++){
				if(j == 0 || i == j){
					list.add(1);
				}else{
					list.add(listSet.get(i - 1).get(j - 1) + listSet.get(i - 1).get(j));
				}
			}
			listSet.add(list);
		}
		return listSet;
	}
}

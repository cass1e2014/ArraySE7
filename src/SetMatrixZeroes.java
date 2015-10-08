/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place. Follow up: Did you use extra space? A straight forward
 * solution using O(mn) space is probably a bad idea. A simple improvement uses
 * O(m + n) space, but still not the best solution. Could you devise a constant
 * space solution?
 * 
 * o(MN) 重新生成一个matrix 
 * o(M+N) 用两个array存first row和first column 
 * o(1) in-place,三遍循环
 * 
 * @author cassie9082
 * 
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0){
            return;
        }
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        boolean empty_row = false;
        boolean empty_col = false;
        //先判断第一排中是否有0，做记号
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                empty_col = true;
                break;
            }
        }
        
        //判断第一列中是否有0，做记号
        for(int i = 0 ; i < columns; i++){
            if(matrix[0][i] == 0){
                empty_row = true;
                break;
            }
        }
        
        //中间非第一行第一列遇到0，先只把第一行第一列变为0
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < columns; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //只要第一行或者第一列中有0，把所有的都翻转
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < columns; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(empty_row){//若一开始第一排中就含有0
            for(int i = 0; i < columns; i++){
                matrix[0][i] = 0;//把第一排都变为0
            }
        }
        
        if(empty_col){//若一开始第一列中就含有0
            for(int j = 0; j < rows; j++){
                matrix[j][0] = 0;//把第一列都变为0
            }
        }
	}
}

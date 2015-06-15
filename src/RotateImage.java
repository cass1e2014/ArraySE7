/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * 完美分析！ http://www.cnblogs.com/chrischennx/p/4009376.html
 * 
 * @author cassie9082
 * 
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        
        int length = matrix.length;
        
		for(int i = 0; i < length / 2; i ++){
		    
			for(int j = 0; j < (length + 1) / 2; j ++){
			    
				int temp = matrix[i][j];
				
				matrix[i][j] = matrix[length - 1 - j][i];
				
				matrix[length - 1- j][i] = matrix[length - 1 - i][length - 1 - j];
				
				matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
				
				matrix[j][length - 1 - i] = temp;
			}
		}
    }
}

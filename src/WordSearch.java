/**
 * Word Search (4/28) Given a 2D board and a word, find if the word exists in
 * the grid. The word can be constructed from letters of sequentially adjacent
 * cell, where "adjacent" cells are those horizontally or vertically
 * neighboring. The same letter cell may not be used more than once. For
 * example, given board = [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", ->
 * returns true, word = "SEE", -> returns true, word = "ABCB", -> returns false.
 */

public class WordSearch {

	public boolean exist(char[][] board, String word) {
		// 考虑board是空集的情况
		if (board == null || board.length == 0)
			return false;
		// 考虑word是空集的情况
		if (word.length() == 0)
			return false;

		// 对于board上的每一格
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// 当遇到一格和word的第一个字符相同的时候，进入find（）看上下左右是否有word的第二个字符
				if (board[i][j] == word.charAt(0)) {
					boolean res = find(board, i, j, word, 0);
					if (res)
						return true;
				}
			}
		}
		return false;

	}

	// recursive
	private boolean find(char[][] board, int i, int j, String word, int start) {
		// 比如“happy”是5位，当我传入的start==5的时候，说明“happy”5个字符都已经通过了判断。所以直接返回true
		// ('y'在第四位）
		if (start == word.length())
			return true;

		// 考虑一些边界情况。比如上下左右找的时候找出了board的界限
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
				|| board[i][j] != word.charAt(start))
			return false;

		// 标记已经走过的字符
		board[i][j] = '#';
		
		//保证了只能寻找自己board[i][j]左右上下的字母
		boolean temp = find(board, i - 1, j, word, start + 1)
				|| find(board, i, j - 1, word, start + 1)
				|| find(board, i + 1, j, word, start + 1)
				|| find(board, i, j + 1, word, start + 1);
		board[i][j] = word.charAt(start);// 还原
		return temp;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };

		WordSearch w = new WordSearch();
		System.out.println(w.exist(board, "ABCCED"));
		System.out.println(w.exist(board, "ABCB"));
	}
}

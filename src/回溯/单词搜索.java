package 回溯;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/6 11:36
 */
public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        boolean[][] booleans = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Arrays.fill(booleans, false);
                if (board[i][j] == chars[0]) if (get(booleans, board, chars, i, j, 1)) return true;
            }
        }
        return false;
    }

    public boolean get(boolean[][] booleans, char[][] board, char[] chars, int i, int j, int index) {
        if (index == chars.length) return true;
        if (booleans[i][j] || chars[index] != board[i][j]) return false;
        booleans[i][j] = true;
        if (i > 0) {
            if (get(booleans, board, chars, i - 1, j, index + 1)) return true;
        }
        if (i < board.length - 1) {
            if (get(booleans, board, chars, i + 1, j, index + 1)) return true;
        }
        if (j > 0) {
            if (get(booleans, board, chars, i, j - 1, index + 1)) return true;
        }
        if (j < board[0].length - 1) {
            if (get(booleans, board, chars, i, j + 1, index + 1)) return true;
        }
        return false;
    }
}

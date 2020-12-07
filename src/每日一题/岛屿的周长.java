package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/30 8:10
 */
public class 岛屿的周长 {
    public int islandPerimeter(int[][] grid) {
        int all = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && grid[0][j] == 1) all++;
                if (j == 0 && grid[i][0] == 1) all++;
                if (grid[i][j] == 0) {
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) all++;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) all++;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) all++;
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) all++;
                }
            }
        }
        return all;
    }
}

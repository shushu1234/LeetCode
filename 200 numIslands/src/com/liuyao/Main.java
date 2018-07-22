package com.liuyao;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

 示例 1:

 输入:
 11110
 11010
 11000
 00000

 输出: 1
 示例 2:

 输入:
 11000
 11000
 00100
 00011

 输出: 3
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    static class Solution {
        int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        static int m;
        static int n;
        boolean[][] visited;

        public int numIslands(char[][] grid) {
            m = grid.length;
            if (grid.length == 0) {
                return 0;
            }
            n = grid[0].length;
            visited = new boolean[m][n];
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        //        从grid[x][y]开始，进行floodfill
//        这个函数的递归终止就是四个方向都遍历完，没有陆地就返回
        private void dfs(char[][] grid, int i, int j) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newx = i + d[k][0];
                int newy = j + d[k][1];
                if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
                    dfs(grid, newx, newy);
                }
            }
//            该问题不会对原来的标记状态标记为false，因为就是要比较陆地
            return;
        }

        private boolean inArea(int newx, int newy) {
            return newx >= 0 && newx < m && newy >= 0 && newy < n;
        }
    }
}

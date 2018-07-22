package com.liuyao;

/**
 *
 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 示例:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 给定 word = "ABCCED", 返回 true.
 给定 word = "SEE", 返回 true.
 给定 word = "ABCB", 返回 false.
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    static class Solution {
//        设置一个辅助数组来确定下一次要转移的方向，四个元素分别代表下一次要走上、右、下、左
        int[][] d={{-1,0},{0,1},{1,0},{0,-1}};
        static int m; //board的行数
        static int n; //board的列数
        static boolean[][] visited; // 访问标记
        public boolean searchWord(char[][] board,String word,int index,int startx,int starty){
            if (index == word.length()-1){
//                最后一个元素，直接判断是否相等
                return board[startx][starty]==word.charAt(index);
            }
//            如果当前元素和要word要比较的元素相等，则继续
            if (board[startx][starty]==word.charAt(index)){
//                设置当前为访问标记为true
                visited[startx][starty]=true;
//                从startx，starty出发，向四个方向寻找
                for (int i = 0; i < 4; i++) {
                    int newx=startx+d[i][0]; //新的行
                    int newy=starty+d[i][1]; //行的列
//                    检查新的位置是否在区域内并且没有被访问过
                    if (inArea(newx,newy)&& !visited[newx][newy]){
                        if (searchWord(board,word,index+1,newx,newy)) {
//                            如果找到返回为true
                            return true;
                        }
                    }
                }
//                清空访问标记
                visited[startx][starty]=false;
            }
//            没找到，返回为false
            return false;
        }

        private boolean inArea(int newx, int newy) {
            return newx>=0 && newx<m && newy>=0 && newy<n;
        }

        public  boolean exist(char[][] board, String word) {
            m=board.length;
            n=board[0].length;
            visited=new boolean[m][n];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (searchWord(board,word,0,i,j)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

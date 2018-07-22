package com.liuyao;

import java.util.LinkedList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



 上图为 8 皇后问题的一种解法。

 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 示例:

 输入: 4
 输出: [
 [".Q..",  // 解法 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // 解法 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 解释: 4 皇后问题存在两个不同的解法。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class Solution {
        List<List<String>> res=new LinkedList<>();
        boolean[] col,dia1,dia2;
        public List<List<String>> solveNQueens(int n) {
            col=new boolean[n]; //同一列不能有两个
            dia1=new boolean[2*n-1]; //两条对角线
            dia2=new boolean[2*n-1];
            LinkedList<Integer> row=new LinkedList<>();
            putQueen(n,0,row);
            return res;
        }

        private void putQueen(int n, int index, LinkedList<Integer> row) {
            if (index==n){
                List<String> list=generate(row);
                res.add(list);
                return;
            }
            for (int i = 0; i < n; i++) {
//            判断同一列和两条对角线，两条对角线上满足 index+i相等和index-i+n-1相等
                if (!col[i] && !dia1[index+i] && !dia2[index-i+n-1]){
                    row.addLast(i);
                    col[i]=true;
                    dia1[index+i]=true;
                    dia2[index-i+n-1]=true;
                    putQueen(n,index+1,row);
                    col[i]=false;
                    dia1[index+i]=false;
                    dia2[index-i+n-1]=false;
                    row.removeLast();
                }
            }
            return;
        }
        //根据记录得到的点的列位置还原出图
        private List<String> generate(LinkedList<Integer> row) {
            LinkedList<String> linkedList=new LinkedList<>();
            for (int i = 0; i < row.size(); i++) {
                StringBuilder stringBuilder=new StringBuilder();
                for (int j = 0; j < row.size(); j++) {
                    stringBuilder.append('.');
                }
                stringBuilder.replace(row.get(i),row.get(i)+1,"Q");
                linkedList.add(stringBuilder.toString());
            }
            return linkedList;
        }
    }

}

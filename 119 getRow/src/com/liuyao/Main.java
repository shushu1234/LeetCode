package com.liuyao;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution.getRow(5);
    }

   static class Solution {
        public static List<Integer> getRow(int rowIndex) {
//            ArrayList<Integer> row = new ArrayList<Integer>();
//            for (int i=0; i<rowIndex+1; i++){
//                row.add(0,1);
//                for(int j=1; j<row.size()-1;j++){
//                    row.set(j, row.get(j)+row.get(j+1));
//                }
//            }
//            return row;
            List<Integer> res = new ArrayList<Integer>(rowIndex+1);
            long nk = 1;
            for(int i = 0; i <= rowIndex; i++){
                res.add((int)nk);
                nk = nk * (rowIndex - i) / (i + 1);
            }
            return res;
        }
    }
}

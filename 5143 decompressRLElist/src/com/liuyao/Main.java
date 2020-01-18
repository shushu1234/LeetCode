package com.liuyao;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = {2, 2, 3, 4};
        for (int i : (new Main().decompressRLElist(arr))) {
            System.out.print(i + " ");
        }
    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}

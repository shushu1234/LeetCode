package com.liuyao;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={1,2,342,4,54,4354,665433,32323};
        System.out.println(new Main().findNumbers(arr));
    }

    public int findNumbers(int[] nums) {
        int total = (int) Arrays.stream(nums).parallel().filter(x -> {
            int count = 0;
            while (x > 0) {
                x /= 10;
                count++;
            }
            return count % 2 == 0 ? true : false;
        }).count();
        return total;
    }
}

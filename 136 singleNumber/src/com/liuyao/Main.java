package com.liuyao;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={2,1,4,2,1};
        System.out.println(new Main().singleNumber(arr));
    }

    public int singleNumber1(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                int res=map.get(nums[i]);
                map.put(nums[i],++res);
            }else {
                map.put(nums[i],1);
            }
        }

        for (Map.Entry<Integer,Integer> temp:map.entrySet()) {
            if (temp.getValue()==1){
                return temp.getKey();
            }
        }
        return 0;
    }

    public int singleNumber(int[] nums) {

//        如果我们对 0 和二进制位做 XOR 运算，得到的仍然是这个二进制位
//        a⊕0=a
//        如果我们对相同的二进制位做 XOR 运算，返回的结果是 0
//        a⊕a=0
//        XOR 满足交换律和结合律
//        a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
//        所以我们只需要将所有的数进行 XOR 操作，得到那个唯一的数字。

        int res = nums[0];
        for(int t = 1 ;t < nums.length;t++)
        {
            res = res^nums[t];
        }
        return res;
    }
}

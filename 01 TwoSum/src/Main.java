import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 */
public class Main {

    public static void main(String[] args) {
        int nums[]=new int[]{2,5,5,11};
        int target=10;
        int result[]=new Solution().twoSum2(nums,target);
        for (int rs :
                result) {
            System.out.println(rs);
        }
    }

}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int temp[]=Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int i,j=0;
        boolean flag=false;
        for (i=0;i<nums.length;i++){
            for (j=(nums.length-1);j>0;j--){
//                System.out.println(i+" "+j);
                if ((nums[i]+nums[j])==target){
                    flag=true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }

        int l=0,n=0;
        int count=0;
        for (int h=0;(h<temp.length)&&(count<2);h++){
            if (nums[i]==temp[h] ){
                l=h;
                count++;
                temp[h]=Integer.MAX_VALUE;
                nums[i]=Integer.MAX_VALUE;
                continue;
            }
            if (nums[j]==temp[h]){
                n=h;
                count++;
                temp[h]=Integer.MAX_VALUE;
                nums[j]=Integer.MAX_VALUE;
                continue;
            }
        }
        if (l>n){
            int k=n;
            n=l;
            l=k;
        }
        return new int[]{l,n};
    }

    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i ;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i );
        }
        return result;
    }
}


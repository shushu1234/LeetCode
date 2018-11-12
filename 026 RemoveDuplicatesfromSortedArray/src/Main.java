public class Main {

    public static void main(String[] args) {
        int[] arr=new int[]{1,1,1,2,2,3,4,4,4,5};
//        int[] arr=new int[]{1,1,2};
        System.out.println(new Solution().removeDuplicates(arr));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int total=1;
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[i-count]){
                //记得要把原来的数组改变过来，否者会出错
                nums[total++]=nums[i];
                count=1;
            }else{
                count++;
            }
        }
        return total;
    }
}

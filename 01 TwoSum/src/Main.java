import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int nums[]=new int[]{2,5,5,11};
        int target=10;
        int result[]=new Solution().twoSum(nums,target);
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
}


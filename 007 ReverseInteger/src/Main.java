public class Main {

    public static void main(String[] args) {
        int a=1230;
        System.out.println(new Solution().reverse(a));
    }
}

class Solution{
    public int reverse(int x){
        long a=0;
        boolean flag=false;
        if (x<0){
            x=Math.abs(x);
            flag=true;
        }
        while ((x/10)>0||(x%10)>0){
            int temp=x%10;
            if ((Integer.MAX_VALUE-a*10)<temp){
                return 0;
            }
            a=temp+a*10;
            x/=10;
        }
        if (flag){
            a*=(-1);
        }
        return (int) a;
    }
}
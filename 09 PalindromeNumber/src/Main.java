public class Main {

    public static void main(String[] args) {
        int x = -123321;
        System.out.println(new Solution().isPalindrome(x));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        String str = x + "";
        int len = str.length();
        int i;
        for (i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i-1)) {
                break;
            }
        }
        if (i==(len/2)){
            return true;
        }else {
            return false;
        }
    }
}
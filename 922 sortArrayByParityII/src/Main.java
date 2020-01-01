/**
 * @author liuyao
 * @date 2018/12/18
 */
public class Main {
    public static void main(String[] args) {
        int[] arr={3,1,4,2};
        System.out.println(Solution.sortArrayByParityII(arr));
    }

    static class Solution {
        public static int[] sortArrayByParityII(int[] A) {
            int i = 0;
            int j = A.length-1;
            boolean excha=false;
            boolean exchb=false;
            while (i <= j) {

                if ((i % 2 != 0 && A[i] % 2 == 0) || (i % 2 == 0 && A[i] % 2 != 0)) {
                    excha=true;
                }else {
                    i++;
                }

                if ((j % 2 != 0 && A[j] % 2 == 0) || (j % 2 == 0 && A[j] % 2 != 0)) {
                    exchb=true;
                }else {
                    j--;
                }

                if (excha&&exchb){
                    int temp=A[i];
                    A[i]=A[j];
                    A[j]=temp;
                    i++;
                    j--;
                    excha=false;
                    exchb=false;
                }
            }
            return A;
        }
    }
}

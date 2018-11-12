import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

/**
 * Created By liuyao on 2018/6/5 22:56.
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = {1};
        System.out.println(Solution.threeSum2(ints));
    }

    static class Solution {
        //        这是一个O(n^2)复杂度的算法
        public static List<List<Integer>> threeSum(int[] nums) {
//            先对数组进行排序
            Arrays.sort(nums);
            List<List<Integer>> res = new LinkedList<>();
//            从0到n-2进行循环操作
            for (int i = 0; i < nums.length - 2; i++) {
//                要对当前的元素是第一个还是之后的元素做一个判断，一确定是否有排序后前后的元素是否相等
                if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
//                    然后在[i+1,nums.length-1]区间进行查找符合的条件的元素
                    int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                    while (lo < hi) {
//                        满足条件
                        if (nums[lo] + nums[hi] == sum) {
//                            添加到res
                            res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
//                            如果nums[lo]之后的元素和它相等，跳过，同理nums[hi]也是
                            while (lo < hi && nums[lo] == nums[lo + 1]) {
                                lo++;
                            }
                            while (lo < hi && nums[hi] == nums[hi - 1]) {
                                hi--;
                            }
                            lo++;
                            hi--;
                        } else if (nums[lo] + nums[hi] < sum) {
                            lo++;
                        } else {
                            hi--;
                        }
                    }
                }
            }
            return res;
        }

        public static List<List<Integer>> threeSum2(int[] nums) {
            List<List<Integer>> lists = new LinkedList<>();
            if (null == nums || nums.length == 0) {
                return lists;
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], (map.get(nums[i])) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }

            if (map.containsKey(0) && map.get(0) >= 3) {
                lists.add(Arrays.asList(0, 0, 0));
            }

            Arrays.sort(nums);

            for (int i = 1, j = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[j] = nums[i];
                    j++;
                }
            }
            for (int i = 0; i < map.size(); i++) {
                for (int j = i + 1; j < map.size(); j++) {
                    if (nums[i] * 2 + nums[j] == 0 && map.get(nums[i]) >= 2) {
                        lists.add(Arrays.asList(nums[i], nums[i], nums[j]));
                    }

                    if (nums[i] + nums[j] * 2 == 0 && map.get(nums[j]) >= 2) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[j]));
                    }

                    int c = 0 - nums[i] - nums[j];
                    if (c > nums[j] && map.containsKey(c)) {
                        lists.add(Arrays.asList(nums[i], nums[j], c));
                    }
                }
            }
            return lists;
        }
    }
}

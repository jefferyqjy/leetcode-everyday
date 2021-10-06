package easy.ThirdMax;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @description:
 * 官方题解：https://leetcode-cn.com/problems/third-maximum-number/solution/di-san-da-de-shu-by-leetcode-solution-h3sp/
 * @author: jefferyqjy
 * @datetime: 2021/10/6 13:17
 */
public class OfficialSolution {

    public static void main(String[] args) {
        int[] nums = {1, 2, -2147483648};
        System.out.println("第三大的数为：" + thirdMax2(nums));

    }

    /**
     * 先排序后取值
     *
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int num = nums[length - 1];
        int count = 1;
        for (int i = length - 2; i >= 0; i--) {
            int a = nums[i];
            if (a != num) {
                count++;
            }
            if (count == 3) {
                return a;
            }
            num = a;
        }
        return nums[length - 1];
    }

    /**
     * 利用了TreeSet有序的特性
     *
     * @param nums
     * @return
     */
    public static int thirdMax2(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i : nums) {
            ts.add(i);
            if (ts.size() > 3) {
                ts.remove(ts.first());
            }
        }

        return ts.size() == 3 ? ts.first() : ts.last();
    }

    /**
     * 遍历解法
     *
     * @param nums
     * @return
     */
    public static int thirdMax3(int[] nums) {
        // 这里用Long.MIN_VALUE而不是用Integer.MIN_VALUE，是因为要考虑数组中出现Integer.MIN_VALUE，即-2147483648的情况，这样的情况最后return的时候那个判断就会有问题；
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] < first && nums[i] > second) { // 这里和下面必须要加上nums[i] < first 或者 nums[i] < second，是为了避免有相同数字的情况
                third = second;
                second = nums[i];
            } else if (nums[i] < second && nums[i] > third) {
                third = nums[i];
            }
        }

        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}

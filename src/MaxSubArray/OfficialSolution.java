package MaxSubArray;

/**
 * @description: 官方题解：https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
 * @author: jefferyqjy
 * @datetime: 2021/9/27 11:26
 */
public class OfficialSolution {

    /**
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int pre = 0;
        int max = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }

        return max;
    }
}

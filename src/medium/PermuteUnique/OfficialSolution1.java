package medium.PermuteUnique;

import java.util.Arrays;

/**
 * @description: 官方题解：https://leetcode-cn.com/problems/reordered-power-of-2/solution/zhong-xin-pai-xu-de-dao-2-de-mi-by-leetc-4fvs/
 * 方法一：搜索回溯 + 位运算
 * 涉及到的其他算法题：
 * 1、全排列：https://leetcode-cn.com/problems/permutations-ii/
 * 2、2的幂：https://leetcode-cn.com/problems/power-of-two/
 * 时间复杂度：O(m!)
 * 空间复杂度：O(m+n) = O(2m) = O(m)
 * @author: jefferyqjy
 * @datetime: 2021/10/28 16:57
 */
public class OfficialSolution1 {

    boolean[] vis;

    public boolean reorderedPowerOf2(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        return backtrack(nums, 0, 0);
    }

    public boolean backtrack(char[] nums, int idx, int num) {
        if (idx == nums.length) {
            return isPowerOfTwo(num);
        }
        for (int i = 0; i < nums.length; ++i) {
            // 不能有前导零
            if ((num == 0 && nums[i] == '0') || vis[i] || (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            vis[i] = true;
            if (backtrack(nums, idx + 1, num * 10 + nums[i] - '0')) {
                return true;
            }
            vis[i] = false;
        }
        return false;
    }

    public boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

}

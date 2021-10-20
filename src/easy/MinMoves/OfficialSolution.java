package easy.MinMoves;

import java.util.Arrays;

/**
 * @description: 官方题解：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/zui-xiao-cao-zuo-ci-shu-shi-shu-zu-yuan-3meg3/
 * @author: jefferyqjy
 * @datetime: 2021/10/20 14:36
 */
public class OfficialSolution {

    /**
     * 神奇的思考角度：
     * 因此，每次操作既可以理解为使 n-1n−1 个元素增加 11，也可以理解使 11 个元素减少 11。显然，后者更利于我们的计算。
     * 时间复杂度：O(n)O(n)，其中 nn 为数组中的元素数量。我们需要一次遍历求出最小值，一次遍历计算操作次数。
     * 空间复杂度：O(1)O(1)。
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }

}

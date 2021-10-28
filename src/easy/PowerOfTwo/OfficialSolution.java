package easy.PowerOfTwo;

/**
 * @description:
 * 官方题解：https://leetcode-cn.com/problems/power-of-two/solution/2de-mi-by-leetcode-solution-rny3/
 * 方法一：二进制表示
 * 复杂度分析：
 *  时间复杂度：O(1)
 *  空间复杂度：O(1)
 *
 * @author: jefferyqjy
 * @datetime: 2021/10/28 17:03
 */
public class OfficialSolution {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

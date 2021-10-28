package easy.PowerOfTwo;

/**
 * @description:
 * 官方题解：https://leetcode-cn.com/problems/power-of-two/solution/2de-mi-by-leetcode-solution-rny3/
 * 方法二：判断是否为最大 22 的幂的约数
 * 复杂度分析：
 *  时间复杂度：O(1)
 *  空间复杂度：O(1)
 * @author: jefferyqjy
 * @datetime: 2021/10/28 17:06
 */
public class OfficialSolution2 {

    static final int BIG = 1 << 30;

    public boolean isPowerOfTwo(int n) {
        return n > 0 && BIG % n == 0;
    }

}

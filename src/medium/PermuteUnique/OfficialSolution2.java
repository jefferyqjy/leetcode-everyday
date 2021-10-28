package medium.PermuteUnique;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * 官方题解：https://leetcode-cn.com/problems/reordered-power-of-2/solution/zhong-xin-pai-xu-de-dao-2-de-mi-by-leetc-4fvs/
 * 方法二：预处理+哈希表
 * 复杂度分析：
 *  时间复杂度：O(logn)。统计 n 的每个数字的出现次数需要 O(logn) 的时间。
 *  空间复杂度：O(1)。
 * @author: jefferyqjy
 * @datetime: 2021/10/28 16:41
 */
public class OfficialSolution2 {

    public static void main(String[] args) {
        boolean b = reorderedPowerOf2(679213508);
    }

    static Set<String> powerOf2Digits = new HashSet<String>();

    public static boolean reorderedPowerOf2(int n) {
        init();
        return powerOf2Digits.contains(countDigits(n));
    }

    public static void init() {
        for (int n = 1; n <= 1e9; n <<= 1) {
            powerOf2Digits.add(countDigits(n));
        }
    }

    public static String countDigits(int n) {
        char[] cnt = new char[10];
        while (n > 0) {
            ++cnt[n % 10];
            n /= 10;
        }
        return new String(cnt);
    }

}

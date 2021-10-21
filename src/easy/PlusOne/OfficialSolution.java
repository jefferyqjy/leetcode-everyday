package easy.PlusOne;

/**
 * @description: 官方题解：https://leetcode-cn.com/problems/plus-one/solution/jia-yi-by-leetcode-solution-2hor/
 * 官方题解：
 * 1、末尾没有9，则把原数组最后一个数字+1后返回即可；
 * 2、末尾有多个9，则倒序遍历数组，找到没有9的那一位，将其+1，并将后面所谓位数置0后返回；
 * 3、全部是9，则返回一个比原数组多一位且首位是1，其余全是0的新数组；
 * 复杂度分析
 *  时间复杂度：O(n)，其中 nn 是数组 digits 的长度。
 *  空间复杂度：O(1)。返回值不计入空间复杂度。
 * @author: jefferyqjy
 * @datetime: 2021/10/21 12:26
 */
public class OfficialSolution {

    /**
     * 官方解法
     *
     * @param digits
     * @return
     */
    public int[] plusOneOfficial(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    /**
     * 基于官方思路我自己写的
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int index = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                index = i;
                break;
            }
        }
        if (index == length - 1) {
            // 没有9
            digits[length - 1] = ++digits[length - 1];
            return digits;
        } else if (index == -1) {
            // 都是9
            int[] newDigits = new int[length + 1];
            for (int i = 0; i < newDigits.length; i++) {
                newDigits[i] = 0;
            }
            newDigits[0] = 1;
            return newDigits;
        } else {
            // 多个9
            digits[index] = ++digits[index];
            for (int i = index+1; i < digits.length; i++) {
                digits[i] = 0;
            }
            return digits;
        }
    }

}

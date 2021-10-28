package easy.PowerOfTwo;

/**
 * @description: 题目链接：https://leetcode-cn.com/problems/power-of-two/
 * @author: jefferyqjy
 * @datetime: 2021/10/28 17:03
 */
public class MySolution {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        while(n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

}

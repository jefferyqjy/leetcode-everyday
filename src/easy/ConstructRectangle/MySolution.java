package easy.ConstructRectangle;

/**
 * @description: 题目链接：https://leetcode-cn.com/problems/construct-the-rectangle/
 * @author: jefferyqjy
 * @datetime: 2021/10/23 22:38
 */
public class MySolution {

    public static void main(String[] args) {
        System.out.println(constructRectangle(37));
    }

    /**
     * 要求：
     *  1、L * W = AREA
     *  2、L >= W；
     *  3、L与W差距尽可能小；
     * 返回：[L, W]
     * @param area
     * @return
     */
    public static int[] constructRectangle(int area) {
        int[] result = new int[2];
        int w = 1;
        int l = area;
        while (l >= w) {
            if (area % w == 0) {
                result[0] = l;
                result[1] = w;
            }
            w++;
            l = area / w;
        }

        return result;
    }
}

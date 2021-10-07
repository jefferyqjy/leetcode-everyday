package easy.CountSegments;

/**
 * @description: 原题链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 * @author: jefferyqjy
 * @datetime: 2021/10/7 15:49
 */
public class MySolution {

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        countSegments(s);
    }

    public static int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String[] strArray = s.split(" ");
        int length = 0;
        for (int i = 0; i < strArray.length; i++) {
            String str = strArray[i];
            if (!str.isEmpty()) {
                length++;
            }
        }
        return length;
    }
}

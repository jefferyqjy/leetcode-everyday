package easy.StrStr;

/**
 * @description: 官方题解
 * @author: jefferyqjy
 * @datetime: 2021/9/17 18:07
 */
public class OfficialSolution {

    public static void main(String[] args) {
        String haystack = "abeababeabf";
        String needle = "abeabf";
        int i = strStr(haystack, needle);
        System.out.println("i: " + i);
    }

    /**
     * 复杂度分析：
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(m)
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        System.out.println("n(haystack length) = " + n + ", m(needle length) = " + m);
        if (m == 0) {
            return 0;
        }
        System.out.println("申请长度为：" + m + "的pi数组");
        int[] pi = new int[m];
        System.out.println("第一步：");
        // 数组存放前缀函数值
        for (int i = 1, j = 0; i < m; i++) {
            System.out.println("    第" + i + "次循环：");
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
            System.out.println("    i = " + i + ", j = " + j + ", pi[] = " + printArray(pi));
        }
        System.out.println();
        System.out.println();
        System.out.println("第二步：");
        for (int i = 0, j = 0; i < n; i++) {
            System.out.println("    第" + i + "次循环：");
            char haystackChar = haystack.charAt(i);
            char needleChar = needle.charAt(j);
            System.out.println("    haystackChar = " + haystackChar + ", needleChar = " + needleChar);
            while (j > 0 && haystackChar != needleChar) {
                j = pi[j - 1];
                System.out.println("    字符不同，j = pi[j-1] = " + j);
            }
            haystackChar = haystack.charAt(i);
            needleChar = needle.charAt(j);
            System.out.println("    新的haystackChar = " + haystackChar + ", 新的needleChar = " + needleChar);
            if (haystackChar == needleChar) {
                j++;
                System.out.println("    字符相同，j = j++ = " + j);
            }
            System.out.println("    i = " + i + ", j = " + j);
            if (j == m) {
                int result = i - m + 1;
                System.out.println("    j = m = " + j + "找到结果，返回i - m + 1 = " + result);
                return result;
            }
            System.out.println("");
        }

        System.out.println("没有找到结果");
        return -1;
    }

    public static String printArray(int[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += (array[i] + " ");
        }
        return str;
    }

}

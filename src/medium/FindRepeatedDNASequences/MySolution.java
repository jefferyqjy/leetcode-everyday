package medium.FindRepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * 题目链接：https://leetcode-cn.com/problems/repeated-dna-sequences/
 * 官方题解：https://leetcode-cn.com/problems/repeated-dna-sequences/solution/zhong-fu-de-dnaxu-lie-by-leetcode-soluti-z8zn/
 * @author: jefferyqjy
 * @datetime: 2021/10/8 17:28
 */
public class MySolution {

    public static void main(String[] args) {
//        String str = "";
//        long start = System.currentTimeMillis();
//        List<String> repeatedDnaSequences = findRepeatedDnaSequences2(str);
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
        int a = 1;
        System.out.println(1 | 4);
    }

    static final int L = 10;

    /**
     * 官方解法一：哈希表
     * 复杂度分析：
     *  时间复杂度：O(NL)O(NL)，其中 NN 是字符串 \textit{s}s 的长度，L=10L=10 即目标子串的长度。
     *  空间复杂度：O(NL)O(NL)。
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        int n = s.length();
        for (int i = 0; i <= n - L; ++i) {
            String sub = s.substring(i, i + L);
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            if (cnt.get(sub) == 2) {
                ans.add(sub);
            }
        }
        return ans;
    }

    static Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        put('A', 0); // 二进制：00
        put('C', 1); // 二进制：01
        put('G', 2); // 二进制：10
        put('T', 3); // 二进制：11
    }};

    /**
     * 官方解法二：哈希表 + 滑动窗口 + 位运算
     * 复杂度分析
     *  时间复杂度：O(N)O(N)，其中 N 是字符串 s 的长度。
     *  空间复杂度：O(N)O(N)。
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences2(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n <= L) {
            return ans;
        }
        int x = 0;
        for (int i = 0; i < L - 1; ++i) {
            x = (x << 2) | bin.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i <= n - L; ++i) {
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i, i + L));
            }
        }
        return ans;

    }

}

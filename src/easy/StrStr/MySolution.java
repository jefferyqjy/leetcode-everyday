package easy.StrStr;

/**
 * @description: https://leetcode-cn.com/problems/implement-strstr/
 * @author: jefferyqjy
 * @datetime: 2021/9/16 18:43
 */
public class MySolution {

    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";
        int i = strStr(haystack, needle);
        System.out.println("i: " + i);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (needleLength > haystackLength) {
            return -1;
        }

        int finalIndex = -1;
        char firstChar = needle.charAt(0);
        for (int i = 0; i < haystackLength; i++) {
            char currentChar = haystack.charAt(i);
            if (firstChar == currentChar) {
                String substring = haystack.substring(i);
                boolean compare = compare(substring, needle);
                if (compare) {
                    finalIndex = i;
                    break;
                }
            }
        }
        return finalIndex;
    }

    public static boolean compare(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        if (length1 < length2) {
            return false;
        }

        boolean result = true;
        for (int i = 0; i < length2; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 != c2) {
                result = false;
                break;
            }
        }

        return result;
    }
}


package easy.LengthOfLastWord;

/**
 * @description: https://leetcode-cn.com/problems/length-of-last-word/
 * @author: jefferyqjy
 * @datetime: 2021/10/4 16:00
 */
public class MySolution {

    public static void main(String[] args) {
//        String s = " fly to the     moon    ";
//        String s = "";
//        String[] s1 = s.split(" ");
//        for (int i = 0; i < s1.length; i++) {
//            System.out.println(s1[i]);
//        }
//        System.out.println(s1[s1.length-1].length());
        String str = "s";
        int i = lengthOfLastWord2(str);
        System.out.println(i);
    }

    public static int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }

    public static int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = s.length()-1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                start = i;
                break;
            }
        }

        int end = start;
        for (int i = end; i >= 0; i--) {
            end = i;
            if (s.charAt(i) == ' ') {
                end++;
                break;
            }
        }

        return start - end + 1;
    }
}

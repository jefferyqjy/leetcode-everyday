package easy.LengthOfLastWord;

/**
 * @description:
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/length-of-last-word/solution/zui-hou-yi-ge-dan-ci-de-chang-du-by-leet-51ih/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: jefferyqjy
 * @datetime: 2021/10/4 16:31
 */
public class OfficialSolution {

    /**
     * 官方的解法和MySolution中的解法二一样，只不过用while代替了for循环，在代码量上更简洁了一点
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;

    }
}

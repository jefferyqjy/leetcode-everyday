package NextGreaterElement;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:https://leetcode-cn.com/problems/next-greater-element-i/
 * @author: jefferyqjy
 * @datetime: 2021/9/1 16:22
 */
public class OfficialSolution {

    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] result = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    /**
     * 使用单调栈解法
     * 复杂度分析：
     *  时间复杂度：O(M+N)，分别遍历数组num1和数组nums2各一次即可，对于nums2中的每个元素，进栈一次，出栈一次；
     *  空间复杂度：O(N)，我们在遍历nums2时，需要使用栈，以及哈希映射来临时存储答案；
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先处理 nums2，把对应关系存入哈希表
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }

        // 遍历 nums1 得到结果集
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}

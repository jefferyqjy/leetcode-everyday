package NextGreaterElement;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:https://leetcode-cn.com/problems/next-greater-element-i/
 * @author: jefferyqjy
 * @datetime: 2021/9/1 16:01
 */
public class MySolution {

    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] result = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int m = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int nextGreaterElement = -1;
                    int t = j + 1;
                    while (t < nums2.length) {
                        if (nums2[t] > m) {
                            nextGreaterElement = nums2[t];
                            break;
                        }
                        t++;
                    }
                    result[i] = nextGreaterElement;
                }
            }
        }
        return result;
    }

    /**
     * 自己用官方的思路所解
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] result = new int[length];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            int nextGreaterNum = -1;
            int j = i + 1;
            while (j < nums2.length) {
                if (nums2[j] > key) {
                    nextGreaterNum = nums2[j];
                    break;
                }
                j++;
            }
            map.put(key, nextGreaterNum);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}

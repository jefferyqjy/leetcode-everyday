package medium.MajorityElement;

import java.util.*;

/**
 * @description:
 * @author: jefferyqjy
 * @datetime: 2021/10/22 10:32
 */
public class MySolution {

    public static void main(String[] args) {
        System.out.println(2 / 3);
        int[] nums = {1, 2};
        List<Integer> integers = majorityElement2(nums);
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + " ");
        }
    }

    /**
     * 解决方案一，用map存储
     * 复杂度分析：
     *  时间复杂度：O(n)，其中 n 为数组的长度。
     *  空间复杂度：O(n)，其中 n 为数组的长度，使用哈希表需要开辟额外的空间。
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        int size = nums.length / 3;
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                Integer count = map.get(key);
                map.put(key, ++count);
            } else {
                map.put(key, 1);
            }

            if (map.get(key) > size && !list.contains(key)) {
                list.add(key);
            }
        }

        return list;
    }

    /**
     * 排序后累加次数
     * 复杂度分析：
     *  时间复杂度：O(n)，其中 n 为数组的长度。
     *  空间复杂度：O(1)，其中 n 为数组的长度，使用哈希表需要开辟额外的空间。
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement2(int[] nums) {
        int size = nums.length / 3;
        List<Integer> list = new ArrayList<>();

        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }

        Arrays.sort(nums);
        int current = nums[0];
        int count = 1;
        if (count > size) {
            list.add(current);
        }
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if (k == current) {
                count++;
            } else {
                current = k;
                count = 1;
            }

            if (count > size && !list.contains(k)) {
                list.add(k);
            }
        }

        return list;
    }

}

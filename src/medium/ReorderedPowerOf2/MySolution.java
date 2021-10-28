package medium.ReorderedPowerOf2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 题目链接：https://leetcode-cn.com/problems/reordered-power-of-2/
 * @author: jefferyqjy
 * @datetime: 2021/10/28 13:47
 */
public class MySolution {

    public static boolean reorderedPowerOf2(int n) {
        List<Integer> reorderIntList = getReorderIntList(n);
        for (Integer i : reorderIntList) {
            boolean isPowerOf2 = isPowerOf2(i);
            if (isPowerOf2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断数字是否是2的幂
     * @param n
     * @return
     */
    public static boolean isPowerOf2(int n) {
        if (n == 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    /**
     * 根据输入的数字n计算所有可能排列的数字
     *
     * @param n
     * @return
     */
    public static List<Integer> getReorderIntList(int n) {
        List<Integer> result = new ArrayList<>();
        int[] nums = new int[String.valueOf(n).length()];
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            nums[i] = Integer.valueOf(str.substring(i, i + 1));
        }
        List<List<Integer>> reorderNumList = getReorderNum(nums);
        for (List<Integer> list : reorderNumList) {
            if (list.get(0) != 0) {
                int i = assembleIntegerFromList(list);
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 把list组装成数字
     *
     * @param list
     * @return
     */
    public static int assembleIntegerFromList(List<Integer> list) {
        String str = "";
        for (Integer i : list) {
            str += i;
        }
        return Integer.valueOf(str);
    }

    /**
     * 获取数字的所有排列组合
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> getReorderNum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums.length == 1) {
            List<Integer> set = new ArrayList<>();
            set.add(nums[0]);
            result.add(set);
            return new ArrayList<>(result);
        }

        int length = nums.length;
        int[] newNums = new int[length - 1];
        for (int i = 0; i < length; i++) {
            int k = 0;
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    newNums[k] = nums[j];
                    k++;
                }
            }
            List<List<Integer>> reorderNum = getReorderNum(newNums);
            for (int j = 0; j < reorderNum.size(); j++) {
                List<Integer> currentList = new ArrayList<>();
                currentList.add(nums[i]);
                currentList.addAll(reorderNum.get(j));
                result.add(currentList);
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        boolean b = reorderedPowerOf2(468645235);
        long end = System.currentTimeMillis();
        System.out.println(b);
        System.out.println("cost: " + (end - start));
    }

}

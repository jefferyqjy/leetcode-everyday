package medium.PermuteUnique;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: jefferyqjy
 * @datetime: 2021/10/28 15:15
 */
public class MySolution {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        return getReorderNum(nums);
    }

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
        int[] nums = {1, 1, 2};
        List<List<Integer>> list = permuteUnique(nums);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> numList = list.get(i);
            for (int j = 0; j < numList.size(); j++) {
                System.out.print(numList.get(j) + " ");
            }
            System.out.println("");
        }
    }
}

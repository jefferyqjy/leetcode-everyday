package easy.MinMoves;

/**
 * @description:题目链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 * @author: jefferyqjy
 * @datetime: 2021/10/20 13:47
 */
public class MySolution {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int i = minMoves(nums);
        System.out.println(i);
    }

    /**
     * 1、找到最大的数；
     * 2、剩下的数加1；
     * 3、判断是否全部相等，若不相等则循环；
     * 结果：执行结果超出时间限制，额、、、==！
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        int i = 0;
        while(!isElementSame(nums)) {
            int index = findFirstMaxIndex(nums);
            add(nums, index);
            i++;
        }

        return i;
    }

    private static void add(int[] nums, int index) {
        for (int i = 0; i < nums.length; i++) {
            if (i != index) {
                nums[i] = nums[i]++;
            }
        }
    }

    private static int findFirstMaxIndex(int[] nums) {
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    private static boolean isElementSame(int[] nums) {
        int ele = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != ele) {
                return false;
            }
        }
        return true;
    }
}

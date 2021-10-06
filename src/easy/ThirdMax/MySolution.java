package easy.ThirdMax;

/**
 * @description: https://leetcode-cn.com/problems/third-maximum-number/
 * @author: jefferyqjy
 * @datetime: 2021/10/6 12:28
 */
public class MySolution {

    public static void main(String[] args) {
        int[] nums = {2,3,1};
        int i = thirdMax(nums);
        System.out.println("第三大的数为：" + i);
    }
    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return nums[0] >= nums[1] ? nums[0] : nums[1];
        }

        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if(nums[i] < min) {
                min = nums[i];
            }
        }

        int second = min;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > second && nums[i] < max) {
                second = nums[i];
            }
        }

        int third = min;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > third && nums[i] < second) {
                third = nums[i];
            }
        }

        return third == second ? max : third;

    }
}

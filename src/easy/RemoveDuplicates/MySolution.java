package easy.RemoveDuplicates;

/**
 * @description:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author: jefferyqjy
 * @datetime: 2021/9/3 23:50
 */
public class MySolution {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int length = removeDuplicates(nums);
        System.out.println("length: " + length);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int length = nums.length;
        if (length < 2) {
            return length;
        }

        int fast = 1;
        int slow = 1;
        while (fast < length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}

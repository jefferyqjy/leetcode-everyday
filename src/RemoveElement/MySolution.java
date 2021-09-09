package RemoveElement;

/**
 * @description: https://leetcode-cn.com/problems/remove-element/
 * @author: jefferyqjy
 * @datetime: 2021/9/9 10:12
 */
public class MySolution {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int length = removeElement(nums, val);
        System.out.println("length: " + length);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 双指针解法，与RemoveDuplicates题型类似
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
}

package SearchInsert;

/**
 * @description: https://leetcode-cn.com/problems/search-insert-position/
 * @author: jefferyqjy
 * @datetime: 2021/9/23 12:09
 */
public class MySolution {

    public int searchInsert(int[] nums, int target) {
        int m = -1;
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                m = i;
                break;
            }
        }

        return m == -1 ? nums.length : m;
    }

}

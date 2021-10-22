package medium.MajorityElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 官方题解：https://leetcode-cn.com/problems/majority-element-ii/solution/qiu-zhong-shu-ii-by-leetcode-solution-y1rn/
 *
 * @author: jefferyqjy
 * @datetime: 2021/10/22 12:41
 */
public class OfficialSolution {

    /**
     * 官方题解，主要应用了摩尔投票算法。
     * 摩尔投票算法，基本思想是对拼消耗。比如找出一组数字序列出出现次数大于一半的元素，应用摩尔投票算法的核心在于一个事实，即：如果存在满足条件的数，则序列中中有且只可能有一个元素满足出现次数大于一半。
     * 基于这个事实，我们把长度为n的数字序列分为：k个相同的元素x（这个元素就是最终可能的、出现次数大于一半的那个元素）和(n-k)/2对不同的元素，
     * 我们要做的就是把这个(n-k)/2对不同的元素像连连看一样消掉，最终会只剩下那几个相同的数字，再判断一下这个数字是否满足次数大于一半这个条件，就可以了。
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;

        for (int num : nums) {
            if (vote1 > 0 && num == element1) { //如果该元素为第一个元素，则计数加1
                vote1++;
            } else if (vote2 > 0 && num == element2) { //如果该元素为第二个元素，则计数加1
                vote2++;
            } else if (vote1 == 0) { // 选择第一个元素
                element1 = num;
                vote1++;
            } else if (vote2 == 0) { // 选择第二个元素
                element2 = num;
                vote2++;
            } else { //如果三个元素均不相同，则相互抵消1次
                vote1--;
                vote2--;
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                cnt1++;
            }
            if (vote2 > 0 && num == element2) {
                cnt2++;
            }
        }
        // 检测元素出现的次数是否满足要求
        List<Integer> ans = new ArrayList<>();
        if (vote1 > 0 && cnt1 > nums.length / 3) {
            ans.add(element1);
        }
        if (vote2 > 0 && cnt2 > nums.length / 3) {
            ans.add(element2);
        }

        return ans;

    }
}

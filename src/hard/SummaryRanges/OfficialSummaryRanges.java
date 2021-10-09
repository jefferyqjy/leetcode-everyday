package hard.SummaryRanges;

import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * 题目链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/
 * 官方题解：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/solution/jiang-shu-ju-liu-bian-wei-duo-ge-bu-xian-hm1r/
 * 一个比较推荐的图解题解：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/solution/acmjin-pai-ti-jie-tu-jie-dian-he-qu-jian-horp/
 *
 * @author: jefferyqjy
 * @datetime: 2021/10/9 11:30
 */
class OfficialSummaryRanges {

    // 这里使用TreeMap利用了其可以对key进行排序的功能。并且把TreeMap.Entry的key作为区间的开始，把value作为区间的结束
    // 比如entry的key为2，value为4，则这个entry代表了一个[2,4]区间
    TreeMap<Integer, Integer> intervals;

    public OfficialSummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int val) {
        // 找到 l1 最小的且满足 l1 > val 的区间 interval1 = [l1, r1]
        // 如果不存在这样的区间，interval1 为尾迭代器
        // ceilingEntry(val + 1):返回key大于等于val+1的第一个元素
        Map.Entry<Integer, Integer> interval1 = intervals.ceilingEntry(val + 1);
        // 找到 l0 最大的且满足 l0 <= val 的区间 interval0 = [l0, r0]
        // 在有序集合中，interval0 就是 interval1 的前一个区间
        // 如果不存在这样的区间，interval0 为尾迭代器
        // floorEntry(val):返回key小于等于val的第一个元素
        Map.Entry<Integer, Integer> interval0 = intervals.floorEntry(val);

        if (interval0 != null && interval0.getKey() <= val && val <= interval0.getValue()) {
            // 情况一：新加入的这个value，在一个已存在的区间内，所以整个TreeMap不需要变动
            return;
        } else {
            // interval0不为空，说明存在区间起始比新加入的数字小的这么一个区间，interval0.getValue() + 1 == val意味着新加入的这个点，正好连在前面说的这个区间的尾部
            boolean leftAside = interval0 != null && interval0.getValue() + 1 == val;
            // interval1不为空，说明存在区间起始比新加入的数字大的这么一个区间，interval1.getKey() - 1 == val意味着新加入的这个点，正好连在前面说的这个区间的头部
            boolean rightAside = interval1 != null && interval1.getKey() - 1 == val;
            if (leftAside && rightAside) {
                // 情况四：这种情况意味着新加入的这个数字正好卡在两个区间中间，相当于这个数字把前后两个区间连起来了
                // 所以这里把前面那个区间的起始，也就是interval0的key，作为新的区间的起始，把后面那个区间的结束，也就是interval1的的value，作为新的区间的结束
                int left = interval0.getKey(), right = interval1.getValue();
                // 这里把老的两个interval0和interval1删掉，意思就是把老的两个区间删掉
                intervals.remove(interval0.getKey());
                intervals.remove(interval1.getKey());
                // TreeMap里加上新产生的一个区间
                intervals.put(left, right);
            } else if (leftAside) {
                // 情况二：这种情况就是新加入的这个数字贴在了比它小的这个区间的尾部，那就把这个区间的结束位置+1就行了
                intervals.put(interval0.getKey(), interval0.getValue() + 1);
            } else if (rightAside) {
                // 情况三：这种情况就是新加入的这个数字加在了比它大的那个区间的头部，所以先把老的那个区间删掉，然后put进一个新的区间，这个区间的起始位置就是新加入的这个数字，结束位置不变
                int right = interval1.getValue();
                intervals.remove(interval1.getKey());
                intervals.put(val, right);
            } else {
                // 情况五：最后一种情况就是前后都不挨着，那就自己加一个区间就行了
                intervals.put(val, val);
            }
        }
    }

    public int[][] getIntervals() {
        int size = intervals.size();
        int[][] ans = new int[size][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            int left = entry.getKey(), right = entry.getValue();
            ans[index][0] = left;
            ans[index][1] = right;
            ++index;
        }
        return ans;
    }

    public static void main(String[] args) {
        OfficialSummaryRanges obj = new OfficialSummaryRanges();
        obj.addNum(1);
        printArray(obj.getIntervals());
        obj.addNum(3);
        printArray(obj.getIntervals());
        obj.addNum(7);
        printArray(obj.getIntervals());
        obj.addNum(2);
        printArray(obj.getIntervals());
        obj.addNum(6);
        printArray(obj.getIntervals());
        obj.addNum(2);
        printArray(obj.getIntervals());
        obj.addNum(4);
        printArray(obj.getIntervals());
        obj.addNum(9);
        printArray(obj.getIntervals());
        obj.addNum(6);
        printArray(obj.getIntervals());
        obj.addNum(9);
        printArray(obj.getIntervals());
        obj.addNum(2);
        printArray(obj.getIntervals());
        obj.addNum(8);
        printArray(obj.getIntervals());
        obj.addNum(4);
        printArray(obj.getIntervals());
    }

    private static void printArray(int[][] array) {
        System.out.println("-------start--------");
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i][0];
            int i2 = array[i][1];
            System.out.println(i + ": " + i1 + ", " + i2);
        }
        System.out.println("-------end--------");
        System.out.println();
        System.out.println();
        System.out.println();
    }

}

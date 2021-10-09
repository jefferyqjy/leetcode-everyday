package hard.SummaryRanges;

import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: jefferyqjy
 * @datetime: 2021/10/9 19:29
 */
public class SummaryRanges {
    TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int val) {

        Map.Entry<Integer, Integer> intervalLarger = intervals.ceilingEntry(val + 1);
        Map.Entry<Integer, Integer> intervalSmaller = intervals.floorEntry(val);

        if(intervalSmaller != null && intervalSmaller.getKey() <= val && intervalSmaller.getValue() >= val) {
            return ;
        } else {
            boolean leftAside = intervalSmaller != null && intervalSmaller.getValue() + 1 == val;
            boolean rightAside = intervalLarger != null && intervalLarger.getKey() -1 == val;
            if(leftAside && rightAside) {
                int left = intervalSmaller.getKey();
                int right = intervalLarger.getValue();
                intervals.remove(intervalSmaller.getKey());
                intervals.remove(intervalLarger.getKey());
                intervals.put(left, right);
            } else if(leftAside) {
                intervals.put(intervalSmaller.getKey(), val);
            } else if(rightAside) {
                int right = intervalLarger.getValue();
                intervals.remove(intervalLarger.getKey());
                intervals.put(val, right);
            } else {
                intervals.put(val, val);
            }
        }

    }

    public int[][] getIntervals() {
        int size = intervals.size();
        int[][] ans = new int[size][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            int left = entry.getKey();
            int right = entry.getValue();
            ans[index][0] = left;
            ans[index][1] = right;
            index++;
        }

        return ans;
    }
}

package easy.DistributeCandies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: jefferyqjy
 * @datetime: 2021/11/1 22:53
 */
public class MySolution {

    public int distributeCandies(int[] candyType) {
        int total = candyType.length;
        int each = total / 2;

        List<Integer> sister = new ArrayList<>();
        List<Integer> brother = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            if (!sister.contains(candyType[i]) && sister.size() < each) {
                sister.add(candyType[i]);
            } else if (brother.size() >= each) {
                sister.add(candyType[i]);
            } else {
                brother.add(candyType[i]);
            }
        }
        Set<Integer> set = new HashSet<>(sister);
        return set.size();
    }
}

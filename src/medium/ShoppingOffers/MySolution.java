package medium.ShoppingOffers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: jefferyqjy
 * @datetime: 2021/10/24 17:53
 */
public class MySolution {

    public static void main(String[] args) {
        List<Integer> price = Arrays.stream(new int[]{0, 0, 0}).boxed().collect(Collectors.toList());
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.stream(new int[]{1, 1, 0, 4}).boxed().collect(Collectors.toList()));
        special.add(Arrays.stream(new int[]{2, 2, 1, 9}).boxed().collect(Collectors.toList()));
        List<Integer> needs = Arrays.stream(new int[]{1, 1, 1}).boxed().collect(Collectors.toList());
        int i = shoppingOffers(price, special, needs);
        System.out.println(i);
    }

    static Map<String, Integer> map = new HashMap<>();

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return getCost(price, special, needs);
    }

    public static int getCost(List<Integer> price, List<List<Integer>> specialList, List<Integer> needs) {
        String key = getKey(needs);
        // 如果key存在，则返回临时表中已经存在的最优解
        if (map.containsKey(key)) {
            return map.get(key);
        }

        // 遍历几种大礼包，得出当前需求下的最优解
        Integer minCost = null;
        for (List<Integer> special : specialList) {
            if (specialAvailable(needs, special)) {
                List<Integer> newNeeds = getNewNeedsUsingSpecial(needs, special);
                Integer cost = getCost(price, specialList, newNeeds) + getSpecialCost(special);
                if (minCost == null) {
                    minCost = cost;
                } else {
                    minCost = Math.min(minCost, cost);
                }
            }
        }

        // 如果不能用大礼包，就单纯计算购物清单的总价
        Integer costUsingPrice = getCostUsingPrice(needs, price);
        if (minCost == null) {
            minCost = costUsingPrice;
        } else {
            minCost = Math.min(costUsingPrice, minCost);
        }

        map.put(key, minCost);
        return minCost;
    }

    /**
     * 单纯用商品价格计算总价
     *
     * @param needs
     * @param price
     * @return
     */
    private static Integer getCostUsingPrice(List<Integer> needs, List<Integer> price) {
        Integer total = 0;
        for (int i = 0; i < needs.size(); i++) {
            total += needs.get(i) * price.get(i);
        }
        return total;
    }

    /**
     * 使用大礼包后剩下的购物清单
     *
     * @param needs
     * @param special
     * @return
     */
    private static List<Integer> getNewNeedsUsingSpecial(List<Integer> needs, List<Integer> special) {
        int size = needs.size();
        int[] newNeedsArray = new int[size];
        for (int i = 0; i < size; i++) {
            newNeedsArray[i] = needs.get(i) - special.get(i);
        }
        return Arrays.stream(newNeedsArray).boxed().collect(Collectors.toList());
    }

    /**
     * 判断大礼包是否可用
     * @param needs
     * @param special
     * @return
     */
    private static boolean specialAvailable(List<Integer> needs, List<Integer> special) {
        for (int i = 0; i < needs.size(); i++) {
            if (special.get(i) != 0 && needs.get(i) - special.get(i) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取大礼包的价格
     * @param special
     * @return
     */
    private static int getSpecialCost(List<Integer> special) {
        int size = special.size();
        return special.get(--size);
    }

    /**
     * 把当前的购物需求转成key
     * @param needs
     * @return
     */
    private static String getKey(List<Integer> needs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < needs.size(); i++) {
            sb.append(needs.get(i)).append(",");
        }
        return sb.toString();
    }

}

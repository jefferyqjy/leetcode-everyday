package easy.RomanToInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/roman-to-integer/
 * @author: jefferyqjy
 * @datetime: 2021/8/31 18:56
 */
public class MySolution {

    static Map<String, Integer> singleMap = new HashMap<>();
    static Map<String, Integer> doubleMap = new HashMap<>();

    static {
        singleMap.put("I", 1);
        singleMap.put("V", 5);
        singleMap.put("X", 10);
        singleMap.put("L", 50);
        singleMap.put("C", 100);
        singleMap.put("D", 500);
        singleMap.put("M", 1000);

        doubleMap.put("IV", 4);
        doubleMap.put("IX", 9);
        doubleMap.put("XL", 40);
        doubleMap.put("XC", 90);
        doubleMap.put("CD", 400);
        doubleMap.put("CM", 900);
    }


    public static void main(String[] args) {
        String str = "IV";
        int total = romanToInt(str);
        System.out.println("roman: " + str + ", number: " + total);
    }

    public static int romanToInt(String s) {

        int i = 0;
        int sum = 0;
        int length = s.length();
        while (i < length) {
            int current;
            if (length - i < 2) {
                String str = s.substring(i, i + 1);
                current = singleMap.get(str);
                i += 1;
            } else {
                String str = s.substring(i, i + 2);
                if (doubleMap.keySet().contains(str)) {
                    current = doubleMap.get(str);
                    i += 2;
                } else {
                    str = s.substring(i, i + 1);
                    current = singleMap.get(str);
                    i += 1;
                }
            }

            sum += current;
        }

        return sum;

    }
}

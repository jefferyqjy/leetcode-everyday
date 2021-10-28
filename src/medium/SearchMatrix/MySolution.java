package medium.SearchMatrix;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 题目链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * @author: jefferyqjy
 * @datetime: 2021/10/25 12:37
 */
public class MySolution {

    public static void main(String[] args) {
        int[][] matrix = {{5, 6, 10, 14}, {6, 10, 13, 18}, {10, 13, 18, 19}};
        boolean b = searchMatrix2(matrix, 14);
        System.out.println(b);
    }

    private static Map<String, Integer> map = new HashMap<>();

    /**
     * 暴力解法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0;
        int j = 0;
        while (i < matrix.length && j < matrix[i].length) {
            int current = matrix[i][j];
            // 判断当前节点是否等于目标值，如果等于则直接返回true
            if (current == target) {
                return true;
            }

            // 当前节点置位-1，表示已搜索过，且不匹配目标元素
            map.put(getKey(i, j), -1);

            Integer up = i < 1 || map.containsKey(getKey(i - 1, j)) ? null : matrix[i - 1][j];
            Integer left = j < 1 || map.containsKey(getKey(i, j - 1)) ? null : matrix[i][j - 1];
            Integer down = i >= matrix.length - 1 ? null : matrix[i + 1][j];
            Integer right = j >= matrix[0].length - 1 ? null : matrix[i][j + 1];
        }
        return false;
    }

    private static String getKey(int i, int j) {
        return i + "+" + j;
    }
}

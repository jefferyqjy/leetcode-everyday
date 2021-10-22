package easy.PlusOne;

/**
 * @description: 我太蠢了，15分钟内没有写对
 * @author: jefferyqjy
 * @datetime: 2021/10/21 11:23
 */
public class MySolution {

    public static void main(String[] args) {
        int[] digits = {3,3,9,3,4,4,4,2};
        int[] newDigits = plusOne(digits);
        for (int i = 0; i < newDigits.length; i++) {
            System.out.print(newDigits[i] + " ");
        }
    }

    public static int[] plusOne(int[] digits) {
        int index = 1;
        while (carry(digits, digits.length - index)) {
            index++;
            if (index > digits.length) {
                int[] newDigits = new int[digits.length + 1];
                for (int i = 0; i < digits.length; i++) {
                    newDigits[i + 1] = digits[i];
                }
                digits = newDigits;
            }
        }
        return digits;
    }

    private static boolean carry(int[] digits, int i) {
        digits[i] = (digits[i] + 1) % 10;
        return digits[i] == 0;
    }
}

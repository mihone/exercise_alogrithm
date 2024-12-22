package com.exercise.algorithm.top150.math;
/**
 * 66. 加一
*  @author mihone
*  @since 2024/12/20 21:41
*/
public class PlusOne {

    public static void main(String[] args) {

    }
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if (carry == 0) {
            return digits;
        }
        int[] newDigits = new int[digits.length + 1];
        for (int i = 0; i < digits.length; i++) {
            newDigits[i+1] = digits[i];
        }
        newDigits[0] = 1;
        return newDigits;

    }
}

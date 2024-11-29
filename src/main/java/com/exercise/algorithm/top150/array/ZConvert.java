package com.exercise.algorithm.top150.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 *
 * @author mihone
 * @since 2024/11/27 8:13
 */
public class ZConvert {

    public static void main(String[] args) {
        char[] chars = new char[4];
        System.out.println();
        ZConvert zConvert = new ZConvert();
        System.out.println(zConvert.convert("PAYPALISHIRING", 3));

    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        if (numRows <= 1) {
            return s;
        }
        List<Character[]> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new Character[s.length()]);
        }
        int row = 0;
        int rowStep = 1;
        int col = 0;
        int colStep = 0;
        int index = 0;
        while (index < s.length()) {
            list.get(row)[col] = s.charAt(index);
            index++;
            row+=rowStep;
            col+=colStep;
            if (row == numRows ) {
                rowStep = -rowStep;
                row+=rowStep;
                row+=rowStep;
                colStep = 1;
                col += colStep;
            }else if (row==-1){
                rowStep = -rowStep;
                row+=rowStep;
                row+=rowStep;
                colStep = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            for (Character c : list.get(i)) {
                if (c!=null) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();


    }
}

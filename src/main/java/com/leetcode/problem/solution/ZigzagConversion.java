package com.leetcode.problem.solution;

/**
 * /*
 * 
 * <pre>
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (30.50%)
 * Total Accepted:    284K
 * Total Submissions: 930.6K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 *
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 *
 *
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 *
 * Example 2:
 *
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * </pre>
 * 
 * @author feng.yang
 * @date 2019-02-20
 */
public class ZigzagConversion {
  public static void main(String[] args) {
    String str = "PAYPALISHIRING";
    System.out.println(new ZigzagConversion().convert(str, 3));
  }

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    int row = 0, column = 0;
    int length = s.length();
    int increment = 0;
    char[] arr = new char[numRows * length];
    for (int i = 0; i < length; i++) {
      if (row == 0) {
        increment = 1;
      } else if (row == numRows - 1) {
        increment = -1;
      }
      arr[row * length + column] = s.charAt(i);
      row += increment;
      if (increment == -1) {
        column++;
      }
    }
    char[] result = new char[s.length()];
    int i = 0;
    for (char c : arr) {
      if (c != '\0') {
        result[i++] = c;
      }
    }
    return String.valueOf(result);
  }
}

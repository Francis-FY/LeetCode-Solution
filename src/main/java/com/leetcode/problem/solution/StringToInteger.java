package com.leetcode.problem.solution;

/**
 * <pre>
 * [8] String to Integer (atoi)
 *
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * algorithms
 * Medium (14.46%)
 * Total Accepted:    323.4K
 * Total Submissions: 2.2M
 * Testcase Example:  '"42"'
 *
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical
 * value is out of the range of representable values, INT_MAX (231 − 1) or
 * INT_MIN (−231) is returned.
 *
 *
 * Example 1:
 *
 *
 * Input: "42"
 * Output: 42
 *
 *
 * Example 2:
 *
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus
 * sign.
 * Then take as many numerical digits as possible, which gets 42.
 *
 *
 * Example 3:
 *
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a
 * numerical digit.
 *
 *
 * Example 4:
 *
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a
 * numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Example 5:
 *
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit
 * signed integer.
 * Thefore INT_MIN (−231) is returned.
 * </pre>
 * 
 * @author feng.yang
 * @date 2019-02-20
 */
public class StringToInteger {

  public static void main(String[] args) {
    System.out.println(new StringToInteger().myAtoi("words and 987"));
  }

  public int myAtoi(String str) {
    int result = 0;
    int signValue = 1;
    boolean first = true;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (first) {
        if (c == ' ') {
          continue;
        }

        if (c == '+') {
          first = false;
          continue;
        }
        if (c == '-') {
          signValue = -1;
          first = false;
          continue;
        }
        if (c >= '0' && c <= '9') {
          first = false;
          result = (int) c - (int) '0';
        } else {
          return 0;
        }
      } else {
        if (c >= '0' && c <= '9') {
          int num = (int) c - (int) '0';

          int tmpNum = num * signValue;
          int tmpResult = signValue * result;
          if (tmpResult > Integer.MAX_VALUE / 10
              || (tmpResult == Integer.MAX_VALUE / 10 && tmpNum > Integer.MAX_VALUE % 10)) {
            return Integer.MAX_VALUE;
          }

          if (tmpResult < Integer.MIN_VALUE / 10
              || (tmpResult == Integer.MIN_VALUE / 10 && tmpNum < Integer.MIN_VALUE % 10)) {
            return Integer.MIN_VALUE;
          }
          result = result * 10 + num;
        } else {
          break;
        }
      }
    }
    return result * signValue;
  }
}

package com.leetcode.problem.solution;

/**
 * <pre>
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (41.74%)
 * Total Accepted:    505.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '121'
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome
 * when it reads the same backward as forward.
 *
 * Example 1:
 *
 *
 * Input: 121
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 *
 *
 * Example 3:
 *
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 *
 *
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 * </pre>
 * 
 * @author feng.yang
 * @date 2019-02-21
 */
public class PalindromeNumber {

  public static void main(String[] args) {
    System.out.println(new PalindromeNumber().isPalindrome1(101));
  }

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int[] arr = new int[11];
    int num = x, i = 0;
    while (num > 0) {
      arr[i++] = num % 10;
      num /= 10;
    }
    for (int j = 0; j <= i && i > 0; j++) {
      if (arr[j] != arr[--i]) {
        return false;
      }
    }
    return true;
  }

  public boolean isPalindrome1(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int revertNum = 0;
    while (x > revertNum) {
      revertNum = revertNum * 10 + x % 10;
      x /= 10;
    }

    return revertNum == x || x == revertNum / 10;
  }

  // private int
}

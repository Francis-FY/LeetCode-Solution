package com.leetcode.problem.solution;

/**
 * <pre>
 * app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.44%)
 * Total Accepted:    471.5K
 * Total Submissions: 1.8M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 *
 * Example 2:
 *
 *
 * Input: "cbbd"
 * Output: "bb"
 * </pre>
 *
 * @author feng.yang
 * @date 2019-02-20
 */
public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    String string = "sreguhasasoghasiolsghegehgsloisahhasuiegykasuyegoasegyaos";
    System.out.println(new LongestPalindromicSubstring().longestPalindrome1(string));
  }

  public String longestPalindrome(String s) {
    if (s.length() <= 1)
      return s;
    for (int i = s.length(); i > 0; i--) {
      for (int j = 0; j <= s.length() - i; j++) {
        String sub = s.substring(j, i + j);
        int count = 0;
        for (int k = 0; k < sub.length() / 2; k++) {
          if (sub.charAt(k) == sub.charAt(sub.length() - k - 1))
            count++;
        }
        if (count == sub.length() / 2)
          return sub;
      }
    }
    return "";
  }

  public String longestPalindrome1(String s) {
    int length = s.length();
    boolean[] dp = new boolean[length * length];
    int start = 0, maxLength = 0;

    for (int i = 0; i < length; i++) {
      for (int j = 0; j <= i; j++) {
        if (i - j < 2) {
          dp[j * length + i] = s.charAt(i) == s.charAt(j);
        } else {
          dp[j * length + i] = s.charAt(i) == s.charAt(j) && dp[(j + 1) * length + i - 1];
        }

        if (dp[j * length + i] && maxLength < i - j + 1) {
          maxLength = i - j + 1;
          start = j;
        }
      }
    }
    return s.substring(start, start + maxLength);
  }
}

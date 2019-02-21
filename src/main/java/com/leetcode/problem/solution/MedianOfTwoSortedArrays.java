package com.leetcode.problem.solution;

/**
 * <pre>
 * &#64;lc app=leetcode id=4 lang=java
 *     [4] Median of Two Sorted Arrays
 *     https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *     algorithms Hard (25.40%) Total Accepted: 378.7K Total Submissions: 1.5M Testcase Example: '[1,3]\n[2]'
 *
 *     There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 *     Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 *     You may assume nums1 and nums2 cannot be both empty.
 *
 *     Example 1:
 *     nums1 = [1, 3] nums2 = [2]
 *     The median is 2.0
 *     Example 2:
 *     nums1 = [1, 2] nums2 = [3, 4]
 *     The median is (2 + 3)/2 = 2.5
 * </pre>
 * 
 * @author feng.yang
 * @date 2019-02-20
 */
class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    int[] arr1 = new int[] {1, 2};
    int[] arr2 = new int[] {3, 4};

    System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(arr1, arr2));
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int i = 0, m = nums1.length - 1, j = 0, n = nums2.length - 1;
    int totalLength = nums1.length + nums2.length;
    for (; totalLength > 2;) {
      if (i > m || (j <= n && nums1[i] >= nums2[j])) {
        j++;
      } else if (j > n || (i <= m && nums1[i] < nums2[j])) {
        i++;
      }

      if (n < j || (m >= i && nums1[m] >= nums2[n])) {
        m--;
      } else if (m < i || (n >= j && nums1[m] < nums2[n])) {
        n--;
      }

      totalLength -= 2;
    }

    if (totalLength == 1) {
      if (i == m) {
        return nums1[i];
      } else if (j == n) {
        return nums2[j];
      }
    } else {
      int num1 = 0, num2 = 0;
      if (i == m - 1) {
        num1 = nums1[i];
        num2 = nums1[m];
      } else if (j == n - 1) {
        num1 = nums2[j];
        num2 = nums2[n];
      } else {
        num1 = nums1[i];
        num2 = nums2[j];
      }
      return (num1 + num2) / 2D;
    }
    throw new IllegalArgumentException();
  }

  public double findMedianSortedArrays1(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    if (m > n) { // to ensure m<=n
      int[] temp = A;
      A = B;
      B = temp;
      int tmp = m;
      m = n;
      n = tmp;
    }
    int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
    while (iMin <= iMax) {
      int i = (iMin + iMax) / 2;
      int j = halfLen - i;
      if (i < iMax && B[j - 1] > A[i]) {
        iMin = i + 1; // i is too small
      } else if (i > iMin && A[i - 1] > B[j]) {
        iMax = i - 1; // i is too big
      } else { // i is perfect
        int maxLeft = 0;
        if (i == 0) {
          maxLeft = B[j - 1];
        } else if (j == 0) {
          maxLeft = A[i - 1];
        } else {
          maxLeft = Math.max(A[i - 1], B[j - 1]);
        }
        if ((m + n) % 2 == 1) {
          return maxLeft;
        }

        int minRight = 0;
        if (i == m) {
          minRight = B[j];
        } else if (j == n) {
          minRight = A[i];
        } else {
          minRight = Math.min(B[j], A[i]);
        }

        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0.0;
  }

  public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;

    if (m > n) {
      int[] tmp = nums1;
      nums1 = nums2;
      nums2 = tmp;

      int tmpm = m;
      m = n;
      n = tmpm;
    }

    int min = 0, max = m, halfLen = (m + n + 1) / 2;
    while (min <= max) {
      int i = (min + max) / 2;
      int j = halfLen - i;
      if (i < max && nums1[i] < nums2[j - 1]) {
        min = i + 1;
      } else if (i > min && nums1[i - 1] > nums2[j]) {
        max = i - 1;
      } else {
        int maxLeft = 0;
        if (i == 0) {
          maxLeft = nums2[j - 1];
        } else if (j == 0) {
          maxLeft = nums1[i - 1];
        } else {
          maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        }
        if ((m + n) % 2 == 1) {
          return maxLeft;
        }

        int minRight = 0;
        if (i == m) {
          minRight = nums2[j];
        } else if (j == n) {
          minRight = nums1[i];
        } else {
          minRight = Math.min(nums1[i], nums2[j]);
        }

        return (maxLeft + minRight) / 2D;
      }
    }

    return 0.0;
  }
}

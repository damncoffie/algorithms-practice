package com.leetcode.medium.binarysearch;

/**
 * #162
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Given a 0-indexed integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 */
public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(new FindPeakElement().findPeakElement(new int[]{1, 2, 3, 1})); // 2
        System.out.println(new FindPeakElement().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4})); // 5
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0; // single element

        int n = nums.length;

        // check if 0th/n-1th index is the peak element
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        // search in the remaining array
        int start = 1;
        int end = n - 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) { // if mid == peak ( case 2 )
                return mid;
            } else if (nums[mid] < nums[mid - 1]) { // downward slope and search space left side ( case 1)
                end = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) { // upward slope and search space right side ( case 3 )
                start = mid + 1;
            }
        }

        return -1; // dummy return statement
    }
}

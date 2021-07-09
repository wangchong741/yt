package com.likou.lookup;

/**
 * 二分查找1
 *
 * @author 技惊四座
 * @date 2021-07-08 15:21
 */
public class BinarySearch {
    public static void main(String[] args) {
        int binarySearch = binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        System.out.println(binarySearch);
    }

    static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}

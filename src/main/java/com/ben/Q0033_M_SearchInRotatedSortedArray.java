package com.ben;

public class Q0033_M_SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // if compare nums[left] and nums[mid] must using <=,
            // since mid could be equals to left (like left=0, right=1, mid=0)
            // if compare nums[mid] and nums[right], using <
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
//        int target = 3;
//        int target = 6;

//        int[] nums = new int[]{3, 1};
//        int target = 1;

        System.out.println(search(nums, target));
    }
}

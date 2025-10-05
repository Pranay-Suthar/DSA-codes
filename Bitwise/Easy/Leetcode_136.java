package Bitwise.Easy;

public class Leetcode_136 {
//    136. Single Number
//    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//    You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//    Example 1:
//    Input: nums = [2,2,1]
//    Output: 1
//
//    Example 2:
//    Input: nums = [4,1,2,1,2]
//    Output: 4
//
//    Example 3:
//    Input: nums = [1]
//    Output: 1
    public static void main(String[] args) {
        int[] arr = {2 ,2 ,1};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        int current = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = current ^ nums[i];
        }

        return current;
    }
}

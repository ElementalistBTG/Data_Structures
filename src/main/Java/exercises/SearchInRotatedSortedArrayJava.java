package exercises;

import java.net.InterfaceAddress;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e. 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2)
 * You are given a target value to search. If found in the array return its index, otherwise return -1
 * You may ssume no duplicate exists in the array
 */

public class SearchInRotatedSortedArrayJava {
    public int search(int[] nums, int target){
        int lo =0, hi = nums.length;
        while(lo<hi){
            int mid = (lo + hi) /2;

            double num = (nums[mid]<nums[0]) ==(target<nums[0])? nums[mid] : target<nums[0]? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;

            if(num<target)
                lo = mid+1;
            else if(num>target)
                hi = mid;
            else
                return mid;
        }
        return -1;
    }
}

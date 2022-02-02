package Exercises

/**
 *Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true

Example 2:

Input: nums = [1,2,3,4]
Output: false

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

 */

class ContainsDuplicate{
    fun containsDuplicate(nums: IntArray): Boolean {
        nums.sort()
        for(i in 0..nums.size-2){
            if(nums[i]==nums[i+1]) return true
        }
        return false
    }//kinda brute force approach O(n) time, O(1) space

    fun containsDuplicate2(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for(num in nums){
            if(set.contains(num)){
                return true
            }else{
                set.add(num)
            }
        }
        return false
    }//space intense approach. O(n) space, O(n) time

    fun containsDuplicate3(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        for (element in nums) {
            if (!set.add(element)) {
                return true
            }
        }
        return false
    }//same code but WAY faster!

    fun <T:Any> Solution  (array : Array<T>) : Boolean{
        val mySet = HashSet<T>()
        for (value in array){
            if(!mySet.contains(value)){
                mySet.add(value)
            }else{
                return true
            }
        }
        return false
    }
}

fun main(){
    val class1 = ContainsDuplicate()
    val myArray = intArrayOf(1,2,3,4,5,6,8).toTypedArray()
    println(class1.Solution(myArray))

}
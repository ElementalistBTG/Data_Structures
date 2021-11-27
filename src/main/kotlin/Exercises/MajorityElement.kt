package Exercises

import java.util.*


/**
 * Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

class MajorityElement {
    fun findMajorityElement(nums: IntArray): Int {//my solution
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            if (map.containsKey(num)) {
                map[num]?.let { map.replace(num, it, map[num]!!.plus(1)) }
            } else {
                map[num] = 0
            }
        }
        return map.maxByOrNull { it.value }!!.key
        //return map.maxBy { it.value }!!.key
    }//Time O(n), Space O(n)

    private fun countNums(nums: IntArray): Map<Int, Int> {
        val counts: MutableMap<Int, Int> = HashMap()
        for (num in nums) {
            if (!counts.containsKey(num)) {
                counts[num] = 1
            } else {
                counts[num] = counts[num]!! + 1
            }
        }
        return counts
    }

    fun majorityElement(nums: IntArray): Int {
        val counts = countNums(nums)
        var majorityEntry: Map.Entry<Int, Int>? = null
        for (entry in counts.entries) {
            if (majorityEntry == null || entry.value > majorityEntry.value) {
                majorityEntry = entry
            }
        }
        return majorityEntry!!.key
    }//Time O(n), Space O(n)

    //Sorting (since the middle element will be the target one)
    fun majorityElementBySort(nums: IntArray): Int {
        Arrays.sort(nums)
        return nums[nums.size / 2]
    }//Time O(n log(n)), Space O(1)

    //Boyer-Moore Voting Algorithm
    fun majorityElementBM(nums: IntArray): Int {
        var count = 0
        var candidate: Int? = null
        for (num in nums) {
            if (count == 0) {
                candidate = num
            }
            count += if (num == candidate) 1 else -1
        }
        return candidate!!
    }//Time O(n), Space O(1)

    //cool solution
    fun majorityElementCool(nums: IntArray): Int {
        val h = nums.size/2
        return nums
            .toList()
            .groupingBy{it}
            .eachCount()
            .map{it->
                if(it.value > h){
                    it.key
                }
                else{
                    null
                }
            }
            .toList()
            .filter{it->it!=null}[0]!!
    }
}



fun main() {
    val myClass = MajorityElement()
    val value = myClass.findMajorityElement(
        intArrayOf(
            1,
            2,
            3,
            4,
            5,
            2,
            2,
            2,
            2,
            3,
            3,
            3,
            5,
            5,
            5,
            5,
            5,
            5,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1
        )
    )
    println("Majority element is: $value")
}
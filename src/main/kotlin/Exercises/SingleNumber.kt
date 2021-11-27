package Exercises

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

fun main() {
//    val myClass = SingleNumber()
//    val array = intArrayOf(1, 3, 5, 7, 3, 9, 5, 7, 1)
//    println("the number is : ${myClass.singleNumber3(array)}")

//    val myClass = SingleNumber2()
//    val array = intArrayOf(1, 3, 5, 7, 3, 9, 5, 7, 1, 1, 3, 5, 7)
//    println("the number is : ${myClass.singleNumber(array)}")

    val myClass = SingleNumber3()
    val array = intArrayOf(1, 3, 5, 7, 9, 1, 3, 5, 7, 10)
    val numbers = myClass.singleNumber(array)
    println("the numbers are : ${numbers.contentToString()}")

}

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        val set = HashSet<Int>()
        for (i in nums) {
            if (set.contains(i)) {
                set.remove(i)
            } else {
                set.add(i)
            }
        }
        return set.single()
    }

    fun singleNumber2(nums: IntArray): Int {
        var a = 0
        for (element in nums) {
            a = (a xor element)
        }
        return a
    }

    fun singleNumber3(nums: IntArray) = nums.reduce(Int::xor)
}

/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

class SingleNumber2 {
    fun singleNumber(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (i in nums) {
            if (map.containsKey(i))
                map[i] = 0
            else
                map[i] = i
        }

        var value: Int? = 0

        for (i in nums) {
            if (map[i] != 0) {
                value = map[i]
                break
            }
        }

        return value!!
    }

    fun singleNumber2(nums: IntArray): Int {
        return nums
            .toList()
            .groupingBy{it}
            .eachCount()
            .filterValues{v->v==1}
            .keys
            .first()
    }

    fun singleNumber3(nums: IntArray): Int {
        val map = HashMap<Int, Int>()

        for (i in nums.indices) {
            if (map.containsKey(nums[i]))
                map[nums[i]] = map[nums[i]]!! + 1
            else
                map[nums[i]] = 1
        }

        return map.filterValues { it == 1 }.keys.first()
        // or
        // return map.filter{it.value == 1}.keys.iterator().next()
    }

    fun singleNumber4(nums: IntArray): Int =
        nums.fold(0 to 0) { (first, second), num -> with((first xor num) and second.inv()) { this to ((second xor num) and inv()) } }.first
}

/**
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 */

class SingleNumber3 {
    fun singleNumber(nums: IntArray): IntArray {
        val set = HashSet<Int>()
        for(i in nums){
            if(set.contains(i))
                set.remove(i)
            else
                set.add(i)
        }
        return set.toIntArray()
    }
}
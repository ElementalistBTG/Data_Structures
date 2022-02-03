package Exercises

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
 */

class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        for(i in 0..nums.size-2){
            if(nums[i]==0){
                var next = i+1
                while(nums[next] == 0 && next<nums.size-1){
                    next++
                }
                nums[i] = nums[next]
                nums[next] = 0
            }
        }
        println(nums.contentToString())
    }

    //not good solution because it requires extra space
    fun moveZeroes2(nums: IntArray): Unit {
        val numbers = mutableListOf<Int>()
        val zeros = mutableListOf<Int>()
        nums.forEach {
            when (it) {
                0 -> zeros.add(it)
                else -> numbers.add(it)
            }
        }
        val sorted = numbers + zeros
        (sorted).indices.forEach {
            nums[it] = sorted[it]
        }
    } //technically we don't make a copy

    fun moveZeroes3(nums: IntArray): Unit {
        var index =0;
        for(i in nums.indices){
            if(nums[i]!=0){
                nums[index++]=nums[i];
            }
        }
        for(i in index until nums.size){
            nums[i]=0;
        }
    }
}

fun main() {
    val myClass = MoveZeroes()
    val array = intArrayOf(0, 1, 0, 3, 12)
    myClass.moveZeroes(array)
}
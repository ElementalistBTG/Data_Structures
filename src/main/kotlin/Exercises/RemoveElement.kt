package Exercises

/**
 * Ginen an array and a value, remove all instances of that value in place and return the new length
 * Do not allocate extra space for another array. (constant memory)
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length
 */

class RemoveElement{
    fun removeElement(nums:IntArray, value: Int): Int{
        //we use two indices (fast and slow). We the fast index we check if the value is equal to target and update the array with the slow index
        if(nums.isEmpty()) return 0

        var slow = 0
        for (fast in nums.indices){
            if(nums[fast] != value)
                nums[slow++] = nums[fast]
        }//the order of elements is not changed with this approach
        return slow
    }//O(n) time, O(1) space
}

fun main(){
    val myClass = RemoveElement()
    println(myClass.removeElement(intArrayOf(1,1,2,3,4,4,4,),1))
}
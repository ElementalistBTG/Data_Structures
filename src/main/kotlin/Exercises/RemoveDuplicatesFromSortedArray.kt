package Exercises

//given a sorted array, remove the duplicates in place such that each element appear only once and return the new length
//It doesn't matter what you leave beyond the new length

class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        //we use the fast, slow index approach
        if(nums.isEmpty()) return 0

        var j=0
        for(i in 1 until nums.size){
            if(nums[i]!=nums[j])
                nums[++j] = nums[i]
        }
        return ++j
    }
}

fun main(){
    val myClass = RemoveDuplicatesFromSortedArray()
    println(myClass.removeDuplicates(intArrayOf(1,1,2,3,4,4,4,)))
}
package Exercises

//given a sorted array, remove the duplicates in place such that each element appear only once and return the new length
//It doesn't matter what you leave beyond the new length

class RemoveDuplicatesFromSortedArray {

    fun removeDuplicatesReturnArray(nums: IntArray): IntArray { //return the new size
        //we use the fast, slow index approach
        if (nums.isEmpty()) return nums

        var slow = 0
        for (fast in 1 until nums.size) {
            if (nums[fast] != nums[slow])
                nums[++slow] = nums[fast]
        }
        return nums.copyOf(++slow)
    }


    fun removeDuplicates(nums: IntArray): Int { //return the new size
        //we use the fast, slow index approach
        if (nums.isEmpty()) return 0

        var slow = 0
        for (fast in 1 until nums.size) {
            if (nums[fast] != nums[slow])
                nums[++slow] = nums[fast]
        }
        return ++slow
    }

    //my solution for return array
    fun removeDuplicates2(array: IntArray): IntArray {

        //Check the input
        if (array.size < 2) return array

        val returnArray = mutableListOf<Int>()
        var slow = 0
        var fast = 1

        var counter = 1
        while (fast < array.size) {
            if (array[slow] != array[fast]) {
                returnArray.add(array[slow])
                slow += counter
                counter = 1
            } else {
                counter++
            }
            if (fast == array.size - 1) {
                returnArray.add(array[fast])
            }
            fast++
        }

        return returnArray.toIntArray()
    }

}

fun main() {
    val myClass = RemoveDuplicatesFromSortedArray()
    val myArray = intArrayOf(-1, 0, 1, 1, 2, 3, 4, 4, 4 ,5, 6)
    val result = myClass.removeDuplicatesReturnArray(myArray)
    for (i in result) {
        print("$i ")
    }

}


package Exercises

class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            val num =
                if (nums[mid] < nums[0] == target < nums[0]) //both true or both false
                    nums[mid].toDouble()
                else if (target < nums[0])
                    Double.NEGATIVE_INFINITY
                else
                    Double.POSITIVE_INFINITY
            if (num < target)
                lo = mid + 1
            else if (num > target)
                hi = mid
            else
                return mid
        }
        return -1
    }
}

fun main() {
    val myClass = SearchInRotatedSortedArray()
    val myArray = intArrayOf(6, 7, 8, 9, 0, 1, 2, 3, 4)
    val myArray2 = intArrayOf( 9, 0, 1, 2, 3, 4, 6, 7, 8)
    println(myClass.search(myArray2, 9))
}
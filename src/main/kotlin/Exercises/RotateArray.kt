package Exercises

class RotateArray {

    //time-O(n), space-O(1); n is size of array
    fun rotate(nums: IntArray, k: Int) {
        val rotation = k % nums.size
        fun reverseInRange(nums: IntArray, start: Int, end: Int) {
            var s = start
            var e = end
            while (s < e) {
                nums[s] = nums[e].also { nums[e] = nums[s] }
                s++
                e--
            }
        }
        //rotating the whole array puts us back where we started. So we only need to do the remainder of k/size
        reverseInRange(nums, 0, nums.size - 1)
        reverseInRange(nums, 0, rotation - 1)
        reverseInRange(nums, rotation, nums.size - 1)


        for (i in nums.indices) {
            print("${nums[i]} ")
        }
    }

    //time-O(n), space-O(1); n is size of array
    fun rotate2(nums: IntArray, k: Int) {
        var rotation = k % nums.size
        var swap = 0
        var startIdx = 0
        while (startIdx < nums.size) {
            var currIdx = startIdx
            var prev = nums[startIdx]
            do {
                val nextIdx = (currIdx + rotation) % nums.size
                val temp = nums[nextIdx]
                nums[nextIdx] = prev
                prev = temp
                currIdx = nextIdx
                swap++
                if (swap == nums.size) return
            } while (startIdx != currIdx)
            startIdx++
        }
        for (i in nums.indices) {
            print("${nums[i]} ")
        }
    }


}

fun main() {
    RotateArray().rotate(intArrayOf(1,2,3,4,5,6,7,8), 1)
}

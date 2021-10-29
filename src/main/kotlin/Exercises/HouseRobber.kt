package Exercises

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */


class HouseRobber {
    fun rob(nums: IntArray): Int {
        val sums = IntArray(nums.size)
        var maxSum = nums[0]
        for (i in nums.indices) {
            if (i < 2) {
                sums[i] = nums[i]
            } else if (i == 2) {
                sums[i] = nums[i] + sums[i - 2]
            } else {
                sums[i] = nums[i] + max(sums[i - 2], sums[i - 3])
            }
            maxSum = max(maxSum, sums[i])
        }
        return maxSum
    }

    private fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    fun rob2(nums: IntArray?): Int {

        // No houses - can't rob anything
        if (nums == null || nums.isEmpty()) {
            return 0
        }

        // single house - can just rob that one house
        if (nums.size == 1) {
            return nums[0]
        }

        // 2 houses - can rob only the max one of them
        if (nums.size == 2) {
            return nums[0].coerceAtLeast(nums[1])
        }

        // 2nd house to the left
        var twoBefore = nums[0]

        // 1st house to the left
        var oneBefore = nums[0].coerceAtLeast(nums[1])
        var curr = -1
        for (i in 2 until nums.size) {
            curr = (twoBefore + nums[i]).coerceAtLeast(oneBefore)
            twoBefore = oneBefore
            oneBefore = curr
        }
        return curr
    }

    //This is Dynamic Programming (bottom-up approach)

}
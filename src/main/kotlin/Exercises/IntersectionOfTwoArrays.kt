package Exercises

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */


class IntersectionOfTwoArrays {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val result = mutableListOf<Int>()
        val map = HashMap<Int, Int>()
//        for(num in nums1){
//            map[num] = 0
//        }
//        for(num in nums1){
//            map[num] = map[num]!!.plus(1)
//        }
        nums1.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        for (num2 in nums2) {
            if (map[num2] != null) {// or map.contains[num2]
                if (map[num2]!! > 0) {
                    result.add(num2)
                    map[num2] = map[num2]!!.minus(1)
                }
            }
        }
        return result.toIntArray()
    }

    fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
        val list = mutableListOf<Int>()
        val map = mutableMapOf<Int, Int>()
        nums2.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        nums1.forEach {
            val v = map.getOrDefault(it, 0)
            if (v > 0) {
                list.add(it)
                map[it] = v - 1
            }
        }

        return list.toIntArray()
    }

    //using two pointer
    fun intersect3(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()
        val ans = ArrayList<Int>()
        var i = 0
        var j = 0
        while (i < nums1.size && j < nums2.size) {
            when {
                nums1[i] > nums2[j] -> j++
                nums1[i] < nums2[j] -> i++
                else -> {
                    ans.add(nums1[i])
                    i++
                    j++
                }
            }
        }
        return ans.toIntArray()
    }


}

fun main() {
    val myClass = IntersectionOfTwoArrays()
    val array1 = intArrayOf(4, 9, 5)
    val array2 = intArrayOf(9, 4, 9, 8, 4)
    myClass.intersect(array1, array2).forEach { print(" $it ") }
}


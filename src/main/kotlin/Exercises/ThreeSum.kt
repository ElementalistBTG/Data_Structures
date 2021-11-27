package Exercises

/**
Find all unique triplets such as a+b+c=0
 */

class ThreeSum {
    fun Solution(array: IntArray): List<IntArray> {
        //first we sort the array
        array.sort()
        //for each element we make a standard bi-directional 2sum sweep of the remaining part of the array
        val res = mutableListOf<IntArray>()
        for (i in 0..array.size / 2) {
            if (i == 0 || (i > 0 && array[i] != array[i - 1])) {
                var low = i + 1
                var hi = array.size - 1
                var sum = 0 - array[i]
                while (low < hi) {
                    if (array[low] + array[hi] == sum) {
                        res.add(intArrayOf(i, low, hi))
                        //skip same elements
                        while (low < hi && array[low] == array[low + 1]) low++
                        while (low < hi && array[hi] == array[hi - 1]) hi--
                        low++
                        hi--
                    } else if (array[low] + array[hi] < sum) low++
                    else hi--
                }
            }
        }
        return res
    }

}

fun main() {
    val myClass = ThreeSum()
    val array = intArrayOf(-2, -1, 0, 1, 2)
    val result = myClass.Solution(array)
    for(arr in result){
        println(arr.contentToString())
    }

}
package Exercises

import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/**
 *
 * You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Return the number of boomerangs.

Example 1:

Input: points = [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
Example 2:

Input: points = [[1,1],[2,2],[3,3]]
Output: 2
Example 3:

Input: points = [[1,1]]
Output: 0

Input
[[0,0],[1,0],[-1,0],[0,1],[0,-1]]
Output
20
 */

class NumberOfBoomerangs {
    fun numberOfBoomerangs(points: Array<IntArray>): Int {
        if (points.size < 2) return 0

        val mySet = hashSetOf<Double>()
        val myMap = hashMapOf<Double,Int>()
        var boomerangs = 0
        for (i in points.indices) {
            for (j in points.indices) {
                val dist = Math.sqrt(
                    Math.pow((points[i][0] - points[j][0]).toDouble(), 2.0)
                            + Math.pow((points[i][1] - points[j][1]).toDouble(), 2.0)
                )
                if (!myMap.contains(dist)) {
                    myMap[dist] = 1
                } else {
                    boomerangs += 2 * myMap[dist]!!
                    myMap[dist] = myMap[dist]!!.plus(1)
                }
            }
            myMap.clear()
        }
        return boomerangs
    }
}
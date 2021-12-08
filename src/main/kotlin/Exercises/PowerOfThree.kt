package Exercises

import kotlin.math.abs

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.



Example 1:

Input: n = 27
Output: true

Example 2:

Input: n = 0
Output: false

Example 3:

Input: n = 9
Output: true

Example 4:

Input: n = 45
Output: false



Constraints:

-231 <= n <= 231 - 1


Follow up: Could you solve it without loops/recursion?
 */

//solutions https://leetcode.com/problems/power-of-three/solution/
//The solutions are awesome CHECK THEM OUT (solution tab)

class PowerOfThree() {
    fun isPowerOfThree(n: Int): Boolean {
        if (n==1) return true
        if (n % 3 != 0) return false
        var nTemp = 3
        while (n > nTemp) {
            nTemp *= 3
        }
        return nTemp == n
    }

    fun isPowerOfThreeYesOrNo(n: Int): String {
        return if (isPowerOfThree(n)) "Yes" else "No"
    }
}

fun main() {
    val myClass = PowerOfThree()
    println("Is it power of three? -> ${myClass.isPowerOfThreeYesOrNo(-27)}")
}
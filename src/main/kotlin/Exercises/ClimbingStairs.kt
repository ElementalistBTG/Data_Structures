package Exercises

//same as fibonacci sequence (if you think about how the number of ways increase)

/**
 *
 * You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45

 */

class ClimbingStairs() {
    fun climbStairs(n: Int): Int {
        if (n < 2) return 1
        return climbStairs(n-1)+climbStairs(n-2)

    }//too slow obviously

    fun climbStairs2(n: Int): Int{ //dynamic progamming
        val cache = HashMap<Int,Int>()
        cache[1] = 1
        cache[2] = 2
        for(i in 3..n){
            cache[i] = cache[i-1]!! + cache[i-2]!!
        }
        return cache[n]!!
    }


}

fun main() {
    val myClass = ClimbingStairs()
    println("there are ${myClass.climbStairs(4)}  ways to climb these stairs")
}
package dynamic_programming

/**
 * You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

class ClimbStairs {

    fun climbStairs(n: Int): Int{
        val cache = HashMap<Int,Int>()
        cache[1] = 1
        cache[2] = 2
        for(i in 3..n){
            cache[i] = cache[i-1]!! + cache[i-2]!!
        }
        return cache[n]!!
    }
}
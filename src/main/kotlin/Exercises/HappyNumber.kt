package Exercises


/**

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.

Return true if n is a happy number, and false if not.

https://leetcode.com/problems/happy-number/solution/

 */

class HappyNumber {

    //Space complexity O(logn)
    //Time complexity  O(logn)
    fun isHappy(n: Int): Boolean {
        var number = n
        val seen: MutableSet<Int> = HashSet()
        while (number != 1 && !seen.contains(number)) {
            seen.add(number)
            number = getSumOfSquareDigits(number)
        }
        return number == 1
    }

    fun getSumOfSquareDigits(n: Int): Int {
        var sum = 0
        var number = n
        while (number > 0) {
            sum += (number % 10) * (number % 10)
            number /= 10
        }
        return sum
    }


    //Floyd's Cycle-Finding Algorithm
    //Space complexity O(1)
    //Time complexity  O(logn)
    fun getNext(n: Int): Int {
        var n = n
        var totalSum = 0
        while (n > 0) {
            val d = n % 10
            n = n / 10
            totalSum += d * d
        }
        return totalSum
    }

    fun isHappy2(n: Int): Boolean {
        var slowRunner = n
        var fastRunner = getNext(n)
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner)
            fastRunner = getNext(getNext(fastRunner))
        }
        return fastRunner == 1
    }


}

fun main() {
    val myClass = HappyNumber()
    println(myClass.isHappy(19))
}
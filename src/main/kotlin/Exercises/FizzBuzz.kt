package Exercises

/**
 * Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i if non of the above conditions are true.
 */

fun main() {
    val myClass = SolutionFizzBuzz()
    println(myClass.fizzBuzz(16).toString())
}

class SolutionFizzBuzz {
    fun fizzBuzz(n: Int): List<String> {
        val list = mutableListOf<String>()
        for (i in 1..n) {
            val word = if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
            else if (i % 3 == 0) "Fizz"
            else if (i % 5 == 0) "Buzz"
            else i.toString()
            list.add(word)
        }
        return list
    }
}
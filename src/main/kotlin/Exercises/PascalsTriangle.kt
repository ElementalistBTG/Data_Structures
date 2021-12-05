package Exercises


/**
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 */

class PascalsTriangle() {
    fun generateTriangle(numRows: Int): List<List<Int>> {
        val returnList = mutableListOf<List<Int>>()
        returnList.add(listOf(1))
        return if (numRows == 1) returnList
        else {
            for (i in 2..numRows) {
                val newLine = mutableListOf<Int>()
                newLine.add(1)
                for (j in 2 until i) {
                    newLine.add(returnList[i - 2][j - 2] + returnList[i - 2][j - 1])
                }
                newLine.add(1)
                returnList.add(newLine)
            }
            returnList
        }
    }
}

fun main() {
    val myClasss = PascalsTriangle()
    println(myClasss.generateTriangle(5))

}
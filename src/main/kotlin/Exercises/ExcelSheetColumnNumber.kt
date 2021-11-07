package Exercises

import kotlin.math.pow

/**
 * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.
Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
 */

class ExcelSheetColumnNumber {
    fun titleToNumber(columnTitle: String): Int {
        val myMap: Map<String, Int> = mapOf(
            "A" to 1, "B" to 2, "C" to 3, "D" to 4,
            "E" to 5, "F" to 6, "G" to 7, "H" to 8, "I" to 9, "J" to 10,
            "K" to 11, "L" to 12, "M" to 13, "N" to 14, "O" to 15, "P" to 16,
            "Q" to 17, "R" to 18, "S" to 19, "T" to 20, "U" to 21, "V" to 22,
            "W" to 23, "X" to 24, "Y" to 25, "Z" to 26
        )
        var resultNumber: Double = 0.0
        val stringLength = columnTitle.length
        for (i in 0 until stringLength) {
            val char: String = columnTitle[i].toString()
            resultNumber += myMap[char]!! * 26.0.pow((stringLength - i - 1).toDouble())
        }
        return resultNumber.toInt()
    }

    fun titleToNumber2(s: String): Int {
        var ans = 0
        var index = s.length - 1

        while (index >= 0) {
            ans += (s[index].toByte().toInt() - 64) *  Math.pow(26.0, (s.length - 1 - index).toDouble()).toInt()
            index -= 1
        }

        return ans
    }

    fun titleToNumber3(s: String): Int {
        var result = 0

        s.forEach {
            result =result * 26 + it.code - 64
        }
        return result
    }
}

fun main() {
    val myClass = ExcelSheetColumnNumber()
    println(myClass.titleToNumber3("FXSHRXW"))
}
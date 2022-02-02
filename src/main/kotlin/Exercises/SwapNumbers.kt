package Exercises

class SwapNumber() {
    fun swapNumbers(x: Int, y: Int) {
        //without using temporary variable
        var num1 = x //eg.4
        var num2 = y//eg.6
        num1 = num1 + num2//10
        num2 = num1 - num2//4
        num1 = num1 - num2//6
    }
}
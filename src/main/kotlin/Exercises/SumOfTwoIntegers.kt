package Exercises

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */

class SumOfTwoIntegers {
//    fun getSum(a:Int,b:Int): Int{
//        return a.plus(b)
//    }

//    fun getSum(a: Int, b: Int): Int {
//        return intArrayOf(a,b).sum()
//    }

    fun getSum(a: Int, b: Int): Int {
        return if (a.and(b) == 0) a.xor(b) else getSum(a.and(b).shl(1), a.xor(b))
    }


}

fun main(){
    val myClass = SumOfTwoIntegers()
    println(myClass.getSum(1,2))
}
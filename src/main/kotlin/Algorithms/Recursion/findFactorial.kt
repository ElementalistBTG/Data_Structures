class recursionClass {

    //O(n)
    fun findFactorialRecursive(number: Int): Int {
        //kind like input check
        if (number == 1) return 1 //works with 2 also

        return number * findFactorialRecursive(number - 1)

    }

    //O(n)
    fun findFactorialIterative(number: Int): Int {
        var result: Int = 1
        for (i in 2..number) {
            result *= i
        }
        return result
    }


}
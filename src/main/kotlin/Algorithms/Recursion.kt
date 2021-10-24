class recursionClass {

    //O(n)
    fun findFactorialRecursive(number: Int): Int {
        //kind like input check
        if (number == 2) return 2

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

    //fibonacci numbers 0, 1, 1, 2, 3, 5, 8, 13, 21
    fun fibonacciIterative(n: Int): Int { //O(n)
        val array = arrayListOf<Int>(0,1)
        for(i in 2..n){
            array.add(array[i-2]+array[i-1])
        }
        return array.last()//or array[n]
    }

    fun fibonacciRecursive(n:Int): Int{ //O(2^n)
//        if(n==0) return 0
//        else if(n==1) return 1
        if(n<2) return n
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2)
    }
}
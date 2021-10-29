package dynamic_programming

class Memoization {
    fun addTo80(n: Int): Int {
        println("long time")
        return n + 80
    }

    fun memoizeAddTo80(n: Int): Int {
        if (!cache.containsKey(n)) {
            println("long time")
            cache[n] = n + 80
        }
        return cache[n]!!
    }

    companion object {
        var cache = HashMap<Int, Int>()
    }
}
package Exercises

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

class BestTimeToBuyStocks {
    /** Brute Force O(n*n) time, O(1) space */
//    fun maxProfit(prices: IntArray): Int {
//        var max = 0
//        val cache = HashMap<Int, Int>()
//        for (i in 0 until prices.size) {
//            if (cache.containsKey(prices[i])) {
//                continue
//            }
//            for (j in i + 1 until prices.size) {
//                if (prices[i] < prices[j]) {
//                    if (max < prices[j] - prices[i]) {
//                        max = prices[j] - prices[i]
//                    }
//                }
//            }
//            cache[prices[i]] = max
//        }
//        return max
//    }

    // O(n) time, O(1) space
    fun maxProfit(prices: IntArray): Int {
        var minprice = Int.MAX_VALUE
        var maxprofit = 0
        for (i in prices.indices) {
            if (prices[i] < minprice) {
                minprice = prices[i]
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice
            }
        }
        return maxprofit
    }
}
/*
 What we are actually doing is this: for every element, we are calculating the difference between that element and the minimum of all the values before that element and we are updating the maximum profit if the difference thus found is greater than the current maximum profit.
 */
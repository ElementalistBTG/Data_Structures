package Exercises

/**
 *
 *You are given an integer array prices where prices(i) is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.

Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

 */

class BestTimeToBuyStocks2 {

    //mine
    fun maxProfit3(prices: IntArray): Int {
        if (prices.size < 2) return 0
        var max = 0
        var slow = 0
        var fast = 1
        var tempMax = 0
        while (fast < prices.size) {
            if (prices[fast-1] >= prices[fast]) {
                slow = fast
                fast++
                max += tempMax
                tempMax = 0
            } else {
                tempMax = prices[fast] - prices[slow]
                fast++
            }
        }
        max+=tempMax
        return max
    }

    fun maxProfit(prices: IntArray): Int {
        var totalProfit = 0
        var partialProfit = 0
        var loop = 0
        var secondLoop = loop + 1
        while (loop < prices.size - 1 && secondLoop <= prices.size - 1) {
            if (prices[secondLoop] - prices[loop] >= partialProfit) {
                partialProfit = prices[secondLoop] - prices[loop]
                secondLoop++
            } else {
                totalProfit += partialProfit
                partialProfit = 0
                loop = secondLoop
                secondLoop++
            }
        }
        if (partialProfit > 0) totalProfit += partialProfit
        return totalProfit
    }//mine, O(n) time, O(1) space


    //This is a simple solution (if you think about it)
    fun maxProfitSimple(prices: IntArray): Int {
        var maxprofit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1]
        }
        return maxprofit
    }//O(n) time, O(1) space

}

fun main() {
    val myClass = BestTimeToBuyStocks2()
    val myArray = intArrayOf(7, 1, 5, 6, 3, 6, 4, 5)
    println("SOlution is: ${myClass.maxProfit(myArray)}")
}


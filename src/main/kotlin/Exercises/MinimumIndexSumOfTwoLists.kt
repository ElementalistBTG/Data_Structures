package Exercises

import java.util.ArrayList

import java.util.HashMap





/**

Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

https://leetcode.com/problems/minimum-index-sum-of-two-lists/solution/
 */


class MinimumIndexSumOfTwoLists {
    //brute force solution
   // Time complexity : O(l1∗l2∗x) Every item of list1 is compared with all the items of list2. l1 and l2 are the lengths of list1 and list2 respectively. And x refers to average string length.
   // Space complexity : O(l1∗l2∗x). In worst case all items of list1 and list2 are same. In that case, hashmap size grows upto l1∗l2∗x, where x refers to average string length.

    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        val myMap = HashMap<Int, List<String>>()
        var min = Int.MAX_VALUE
        for (i in list1.indices) {
            for (j in list2.indices) {
                if (list1[i] == list2[j]) {
                    if (i + j < min) min = i + j
                    val tempList = mutableListOf<String>()
                    if(!myMap[i + j].isNullOrEmpty()){
                        for (item in myMap[i + j]!!) {
                            tempList.add(item)
                        }
                    }
                    tempList.add(list1[i])
                    myMap[i + j] = tempList
                }
            }
        }
        return myMap[min]!!.toTypedArray()
    }

    fun findRestaurant2(list1: Array<String>, list2: Array<String>): Array<String>? {
        val res: MutableList<String> = ArrayList()
        for (sum in 0 until list1.size + list2.size - 1) {
            for (i in 0..sum) {
                if (i < list1.size && sum - i < list2.size && list1[i] == list2[sum - i]) res.add(list1[i])
            }
            if (res.size > 0) break
        }
        return res.toTypedArray()
    }

    //linear solution
    //Time: O(l1+l2)
    //Space: O(l1*x), x refers to average string length
    fun findRestaurant3(list1: Array<String>, list2: Array<String>): Array<String>? {
        val map = HashMap<String, Int>()
        for (i in list1.indices) map[list1[i]] = i
        val res: MutableList<String> = ArrayList()
        var min_sum = Int.MAX_VALUE
        var sum: Int
        var j = 0
        while (j < list2.size && j <= min_sum) {
            if (map.containsKey(list2[j])) {
                sum = j + map[list2[j]]!!
                if (sum < min_sum) {
                    res.clear()
                    res.add(list2[j])
                    min_sum = sum
                } else if (sum == min_sum) res.add(list2[j])
            }
            j++
        }
        return res.toTypedArray()
    }

}

fun main(){
    val myClass = MinimumIndexSumOfTwoLists()
    val list1 = arrayOf("Shogun","Tapioca Express","Burger King","KFC")
    val list2 = arrayOf("Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun")
    println(myClass.findRestaurant(list1,list2))
}
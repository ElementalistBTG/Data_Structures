package Exercises

import java.util.*

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target
 * You may assume that each input would have exactly one solution and you may noy use the same element twice
 */

class Solution{

    //first solution is to sort the array and then do a for loop to find if a pair exists
    fun twoSum(array: IntArray,target: Int): IntArray{
        //check input
        if(array.size<2){
            //we should have something more elegant here
            return array
        }
        //sort the array
        array.sort() //O(nlog(n)) to sort with built-in DualPivotQuickSort

        var i = 0
        var j = array.size-1
        while(true){ //O(n)
            if(i==j){
                break
            }else{
                if(target>array[i]+array[j]){
                    i++
                }else if(target<array[i]+array[j]){
                    j--
                }else{
                    return intArrayOf(array[i],array[j])
                }
            }
        }
        return array
    }//so we have O(nlog(n)) time complexity, O(n) space complexity

    fun twoSumWithMap(array: IntArray,target: Int): IntArray{
        //return the places of the correct answers
        val returnArray = IntArray(2)
        val map = HashMap<Int,Int>()
        for(i in array.indices){
            //check if the array has an element which equal to the difference between the target and the current element
            val dif = map[target-array[i]]
            if(dif==null){
                map[array[i]] = i
            }else{//match found
                returnArray[0] = dif
                returnArray[1] = i
                break
            }
        }
        return returnArray
    }//O(n) time complexity, O(n) space complexity
}

fun main(){
    val array = intArrayOf(1,3,5,7,9,11)
    val myClass = Solution()
    val resultArray = myClass.twoSumWithMap(array,10)
    println("result= ${resultArray.contentToString()}")
//    println("result= ${Arrays.toString(resultArray)}")
//    println("result= ${resultArray.joinToString("-")}")
//    resultArray.forEach { print(it) }
//    resultArray.forEach(System.out::print)
//    resultArray.forEach(::print)
}
//to print multi-dimensional array you can Arrays.deepToString(array)
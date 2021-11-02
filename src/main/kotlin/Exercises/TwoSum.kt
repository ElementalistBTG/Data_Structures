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
        array.sort()

        var i = 0
        var j = array.size-1
        while(true){
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
    }
}

fun main(){
    val array = intArrayOf(1,3,5,7,9,11)
    val myClass = Solution()
    val resultArray = myClass.twoSum(array,11)
    println("result= ${resultArray.contentToString()}")
//    println("result= ${Arrays.toString(resultArray)}")
//    println("result= ${resultArray.joinToString("-")}")
//    resultArray.forEach { print(it) }
//    resultArray.forEach(System.out::print)
//    resultArray.forEach(::print)
}
//to print multi-dimensional array you can Arrays.deepToString(array)
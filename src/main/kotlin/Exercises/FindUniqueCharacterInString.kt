package Exercises

/**
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"
Output: 0

Example 2:

Input: s = "loveleetcode"
Output: 2

Example 3:

Input: s = "aabb"
Output: -1

 */

class FindUniqueCharacterInString{
    fun firstUniqChar(s: String): Int {
        val map = HashMap<Char,Int>() //or mutableMapOf although hashmap is faster
        for(char in s){
            if(!map.containsKey(char)){
                map[char]=1
            }else{
                map[char]=0
            }
        }
        for(c in s.indices){
            if(map[s[c]]==1) return c
        }
        return -1
    }//O(n) time, O(x) space where x is the number of letters in the specific alphabet

    fun firstUniqChar2(s: String): Int {
        val count = IntArray(26)
        val n = s.length
        // build char count bucket : <charIndex, count>
        for (i in 0 until n) {
            val index = s[i] - 'a'
            count[index]++
        }

        // find the index
        for (i in 0 until n) {
            val index = s[i] - 'a'
            if (count[index] == 1) {
                return i
            }
        }
        return -1
    }//faster implementation using array instead of map
}

fun main(){
    val myClass = FindUniqueCharacterInString()
    val string = "loveleetcode"
    println("index is: ${myClass.firstUniqChar(string)}")
}
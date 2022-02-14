package Exercises

/**

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true

Example 2:

Input: s = "foo", t = "bar"
Output: false

Example 3:

Input: s = "paper", t = "title"
Output: true


 */

class IsomorphicStrings {

    fun isIsomorphic(s: String, t: String): Boolean {
        val myMap : MutableMap<Char,Char> = HashMap<Char,Char>()
        for(i in s.indices){
            if(!myMap.contains(s[i])){
                if(myMap.containsValue(t[i])) return false
                myMap[s[i]] = t[i]
            }else{
                if(myMap[s[i]] != t[i]) return false
            }

        }
        return true
    }
}
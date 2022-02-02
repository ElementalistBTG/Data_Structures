package algorithms.recursion

import data_structures.StackImpl
import data_structures.TreeNode
import kotlin.collections.ArrayList
import kotlin.math.max


class RecursionExamples {
    /*
    Print 1 to n
     */
    fun print1ToN(n: Int) {
        // Base condition
        if (n == 0) return
        print1ToN(n - 1) // Hypothesis
        println(n) // Induction
    }

    /*
    Print n to 1
    */
    fun printNto1(n: Int) {
        // Base condition
        if (n == 0) return
        println(n) // Induction
        printNto1(n - 1) // Hypothesis
    }

    /*
Given the root of a binary tree, return its maximum depth.
In input we have given tree node values & in output we have to return its maximum height.
     */
    fun maxDepth(root: TreeNode?): Int {
        // Base Condition
        if (root == null) return 0
        // Hypothesis
        val left = maxDepth(root.left)
        val right = maxDepth(root.right)
        // Induction
        return max(left, right) + 1//we add the root node that wasn't calculated
    }

    /*
    Sort An Array Using Recursion
     */

    fun sort(arr: ArrayList<Int>): ArrayList<Int> { // sort function
        // Base Condition
        if (arr.size == 1) {
            return arr
        }
        // Hypothesis
        val temp = arr[arr.size - 1] // getting last number out
        arr.removeAt(arr.size - 1) // removing it from array
        sort(arr) // sorting the array that is left
        insert(arr, temp) //re-insert the value at the correct place
        return arr
    }

    fun insert(arr: ArrayList<Int>, temp: Int): ArrayList<Int> { // insert function
        // Base Condition
        if (arr.size == 0 || temp >= arr[arr.size - 1]) { // checking if let say we have 6 in temp & 6 is greater then 5
            arr.add(temp) // we will simply add it into our array
            return arr // and return it
        }
        // Hypothesis
        val lastNum = arr[arr.size - 1] // getting 5 out
        arr.removeAt(arr.size - 1) // removing 5 from array -> [0,1]
        insert(arr, temp) // inserting 2 to [0,1] which becomes -> [0,1,2]

        // Induction
        arr.add(lastNum) // adding 5 to [0,1,2] which becomes -> [0,1,2,5]
        return arr
    }

    /*
    Given a stack, sort it in asscending order
     */
    fun sortStack(st: StackImpl<Int?>): StackImpl<Int?> {
        if (st.count == 1) return st // Base Condition
        // Hypothesis
        val temp = st.pop() // getting 2 out
        sortStack(st) // sorting the stack from [5,1,0] -> [0,1,5]
        return insertElementAtStack(st, temp)
    }

    fun insertElementAtStack(st: StackImpl<Int?>, temp: Int?): StackImpl<Int?> {
        // Base Condition
        if (temp != null) {
            if (st.count == 0 || temp >= st.peek()!!) { // checking if let say we have 6 in temp & 6 is greater then 5
                st.push(temp) // we will simply add it into our stack
                return st
            }
        }
        // Hypothesis
        val value = st.pop() // getting 5 out stack becomes -> [0,1]
        insertElementAtStack(st, temp) // insrting 2 to [0,1] which becomes -> [0,1,2]
        // Induction
        st.push(value) // adding 5 to [0,1,2] which becomes -> [0,1,2,5]
        return st

    }

}
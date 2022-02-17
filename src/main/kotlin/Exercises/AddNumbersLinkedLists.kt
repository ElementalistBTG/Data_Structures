package Exercises

import data_structures.linked_lists.LinkedList

/**
 * Add two numbers represented by linked lists
 *
 * Given two numbers represented by two linked lists, write a function that returns the sum list.
 * The sum list is linked list representation of the addition of two input numbers.
 * It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Hint: Use Recursion).
 *
 * Example :

Input:
First List: 5->6->3
Second List: 8->4->2
Output
Resultant list: 1->4->0->5

 */

class AddNumbersLinkedLists {

//    fun addNumbersLL(list1: LinkedList<Int>, list2: LinkedList<Int>): LinkedList<Int>{
//        val sumList = LinkedList<Int>()
//
//
//    }

}

fun main(){
    val myClass = AddNumbersLinkedLists()
    val list1 = LinkedList<Int>()
    list1.push(3)
    list1.push(6)
    list1.push(5)
    val list2 = LinkedList<Int>()
    list2.push(2)
    list2.push(4)
    list2.push(8)
//    val sumList = myClass.addNumbersLL(list1,list2)
//    while(sumList.isNotEmpty()){
//        println(sumList.pop())
//    }
}
package Exercises

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        var reversed: ListNode? = null

        var current = head
        while (current != null) {
            reversed = ListNode(current.`val`).apply { next = reversed }
            current = current.next
        }

        return reversed
    }

    fun reverseListRecursively(head: ListNode?, prevNode: ListNode? = null): ListNode? {
        return if (head == null) prevNode
        else reverseListRecursively(head!!.next, head).also { head!!.next = prevNode }
    }

    fun reverseList2(head: ListNode?): ListNode? {
        var previous: ListNode? = null
        var current: ListNode? = head
        while (current != null) {
            current.next = previous.also { previous = current }.also { current = current?.next }
        }
        return previous
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
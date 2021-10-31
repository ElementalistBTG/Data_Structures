package data_structures.linked_lists

class Node2(var value: Int) {
    var next: Node2? = null
    var previous: Node2? = null
}

class DoublyLinkedList(value: Int) {
    var head: Node2? = Node2(value)
    var tail: Node2? = head
    var length: Int = 1

    fun append(value: Int) {
        val newNode = Node2(value)
        newNode.previous = tail
        tail?.next = newNode
        tail = newNode
        length++
    }

    fun prepend(value: Int) {
        val newNode = Node2(value)
        head?.previous = newNode
        newNode.next = head
        head = newNode
        length++
    }

    fun printList(): IntArray {
        val myList = IntArray(length)
        var current: Node2? = head
        var i = 0
        while (current != null) {
            myList[i] = current.value
            current = current.next
            i++
        }
        return myList
    }

    fun insert(index: Int, value: Int) {
        if (index < 0 || index > length) {
            println("Index Out Of Bounds For Length $length")
        } else if (index == 0) {
            prepend(value)
        } else if (index == length) {
            append(value)
        } else {
            var current: Node2? = head
            for (i in 0 until index - 1) {
                current = current?.next
            }
            val newNode = Node2(value)
            newNode.next = current?.next
            current?.next = newNode
            newNode.previous = current
            newNode.next?.previous = newNode
            length++
        }
    }

    fun remove(index: Int) {
        if (index < 0 || index > length) {
            println("Index Out Of Bounds For Length $length")
        } else if (index == 0) {
            head = head?.next
            head?.previous = null
            length--
        } else {
            var current: Node2? = head
            var i = 0
            while (i < index - 1) {
                current = current?.next
                i++
            }
            current?.next = current?.next?.next
            length--
            if (i == length - 1) {
                tail = current
            } else {
                current?.next?.previous = current
            }
        }
    }
}

fun main() {
    val myDoublyLinkedList = DoublyLinkedList(5)
    myDoublyLinkedList.append(3)
    myDoublyLinkedList.append(4)
    myDoublyLinkedList.prepend(2)
    myDoublyLinkedList.prepend(1)
    println(myDoublyLinkedList.printList().contentToString())
    myDoublyLinkedList.remove(0)
    println(myDoublyLinkedList.printList().contentToString())
    myDoublyLinkedList.insert(2, 200)
    println(myDoublyLinkedList.printList().contentToString())
    println("length: " + myDoublyLinkedList.length)
    println("head value: " + myDoublyLinkedList.head?.value)
    println("head.previous: " + myDoublyLinkedList.head?.previous)
    println("tail value: " + myDoublyLinkedList.tail?.value)
    println("tail.next: " + myDoublyLinkedList.tail?.next)
}
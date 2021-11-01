package data_structures.queues

class NodeQueue(var value: String?) {
    var next: NodeQueue? = null
}

class QueueLL {
    var first: NodeQueue? = null
    var last: NodeQueue? = null
    var length = 0

    fun peek(): String? {
        return if (length > 0) {
            first?.value
        } else {
            null
        }
    }

    fun enqueue(value: String?) {
        val newNode = NodeQueue(value)
        if (length == 0) {
            first = newNode
        } else {
            last?.next = newNode
        }
        last = newNode
        length++
    }

    fun dequeue() {
        if (length > 0) {
            first = first?.next
            if (length == 1) {
                last = null
            }
            length--
        }
    }

    fun isEmpty() = length == 0
}

fun main() {
    val myQueue = QueueLL()
    println(myQueue.isEmpty())
    println(myQueue.peek())
    myQueue.enqueue("Apple")
    myQueue.enqueue("Ball")
    myQueue.enqueue("Cat")
    myQueue.dequeue()
    println(myQueue.peek())
}
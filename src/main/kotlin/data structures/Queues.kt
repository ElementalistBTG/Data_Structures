package `data structures`

interface Queue<T : Any> {

    fun enqueue(element: T): Boolean

    fun dequeue(): T?

    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0

    fun peek(): T?
}

//implement a queue using arraylist
class ArrayListQueue<T : Any> : Queue<T> {
    private val list = arrayListOf<T>()

    //O(1) operation
    override val count: Int
        get() = list.size
    //O(1) operation
    override fun peek(): T? = list.getOrNull(0)
    //amortized O(1) operation
    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }
    //O(n) operation
    override fun dequeue(): T? =
        if (isEmpty) null else list.removeAt(0)
    //for debugging purposes
    override fun toString(): String = list.toString()
    //space complexity is O(n)
}

//double stack implementation
class StackQueue<T : Any> : Queue<T> {
    private val leftStack = StackImpl<T>()
    private val rightStack = StackImpl<T>()

    override val isEmpty: Boolean
        get() = leftStack.isEmpty && rightStack.isEmpty

    override val count: Int
        get() = leftStack.count + rightStack.count
    //to transfer elements from right to left stack
    private fun transferElements() {
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }
    //amortized O(n) operation due to transferElements method
    override fun peek(): T? {
        if (leftStack.isEmpty) {
            transferElements()
        }
        return leftStack.peek()
    }
    //O(1)
    override fun enqueue(element: T): Boolean {
        rightStack.push(element)
        return true
    }

    override fun dequeue(): T? {
        if (leftStack.isEmpty) {
            transferElements()
        }
        return leftStack.pop()
    }
    //debugging purposes
    override fun toString(): String {
        return "Left stack: \n$leftStack \n Right stack: \n$rightStack"
    }

}

/**
 * Other implementations are doubly linked list and ring-buffer
 */

//exercise: create a board game manager to show you when someone's turn is up
fun <T : Any> Queue<T>.nextPlayer(): T? {
    val person = this.dequeue() ?: return null
    this.enqueue(person)
    return person
}

//`data structures`.reverse a queue (using a stack)
fun <T : Any> Queue<T>.reverse() {
    val aux = StackImpl<T>()

    var next = this.dequeue()
    while (next != null) {
        aux.push(next)
        next = this.dequeue()
    }

    next = aux.pop()
    while (next != null) {
        this.enqueue(next)
        next = aux.pop()
    }
}




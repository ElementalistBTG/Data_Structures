package data_structures

interface Stack<T : Any> {
    fun push(element: T)
    fun pop(): T?
    fun peek(): T?

    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0
}

class StackImpl<T : Any> : Stack<T> {
    private val storage = arrayListOf<T>()

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(count - 1)
    }

    //useful methods
    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    //not mandatory methods
    // In case you want to convert a list to a stack
    companion object {
        fun <T : Any> create(items: Iterable<T>): Stack<T> {
            val stack = StackImpl<T>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }

}

fun <T : Any> stackOf(vararg elements: T): Stack<T> {
    return StackImpl.create(elements.asList())
}

//using stack to `data structures`.reverse a linked list
fun <T : Any> LinkedList<T>.printInReverse2() {
    val stack = StackImpl<T>()

    for (node in this) {
        stack.push(node)
    }

    var node = stack.pop()
    while (node != null) {
        println(node)
        node = stack.pop()
    }
}
/** Test */
/*
    val stack = `data structures`.StackImpl<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
    }
    print(stack)
    val poppedElement = stack.pop()
    if (poppedElement != null) {
        println("Popped: $poppedElement")
    }
    print(stack)
    //list to stack
    val list = listOf("A", "B", "C", "D")
    val stack2 = `data structures`.StackImpl.create(list)
    print(stack2)
    println("Popped: ${stack2.pop()}")
    //create a stack in a similar way as listOf()
    val stack3 = `data structures`.stackOf(1.0, 2.0, 3.0, 4.0)
    print(stack3)
    println("Popped: ${stack3.pop()}")
 */


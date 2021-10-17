fun main() {
    val stack = StackImpl<Int>().apply {
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
    val stack2 = StackImpl.create(list)
    print(stack2)
    println("Popped: ${stack2.pop()}")
    //create a stack in a similar way as listOf()
    val stack3 = stackOf(1.0, 2.0, 3.0, 4.0)
    print(stack3)
    println("Popped: ${stack3.pop()}")
}


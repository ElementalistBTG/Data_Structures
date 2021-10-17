fun main() {
    val myStack = StackViaLL<String>()
    myStack.push("aaa")
    myStack.push("bbb")
    myStack.push("v")
    println("Peek at the stack ${myStack.peek()}")
    myStack.pop()
    println("Empty Stack? :${myStack.isEmpty()}")
    myStack.printStack()
    myStack.pop()
    myStack.pop()
    println("popped ${myStack.pop()}")
    myStack.printStack()
    println("Empty Stack? :${myStack.isEmpty()}")
}


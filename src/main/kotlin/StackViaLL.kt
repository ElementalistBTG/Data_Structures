data class NodeForStack<T : Any?>
    (
    var value: T,
    var next: NodeForStack<T>?
)

//Stack created using Linked List
class StackViaLL<T : Any?>(
    var top: NodeForStack<T>? = null,
    var bottom: NodeForStack<T>? = null,
    var length: Int = 0
) {

    fun peek(): NodeForStack<T>? {
        return top
    }

    fun push(value: T) {
        val newNode = NodeForStack(value = value, next = null)
        //if stack is empty
        if (length == 0) {
            top = newNode
            bottom = newNode
        } else {
            newNode.next = top
            top = newNode
        }
        length++
    }

    fun pop():NodeForStack<T>? {
        if(length==0){
            return null
        }else if(length==1){
            bottom = null
        }
        val temp = top
        top = top?.next
        length--
        return temp
    }

    fun isEmpty(): Boolean {
        return length==0
    }

    fun printStack(){
        var currentNode = top
        println("Our stack has $length length with top=${top} and bottom=${bottom}")
        while(currentNode!=null){
            print("$currentNode ,")
            currentNode = currentNode.next
        }
    }
}
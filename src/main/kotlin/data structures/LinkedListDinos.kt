package `data structures`

/**test code below*/
/*
val myLinkedList = `data structures`.LinkedListDinos<Int>()
    myLinkedList.append(2)
    myLinkedList.append(15)
    myLinkedList.append(37)
    myLinkedList.prepend(91)
    myLinkedList.insert(2,876)
    myLinkedList.remove(1)
    myLinkedList.printList()
    myLinkedList.`data structures`.reverse()
    myLinkedList.printList()
 */


//Note: Using T : Any to set an upper bound for the type parameter ensures that T will always be a non-nullable type.
data class CustomNode<T : Any>(var value: T, var next: CustomNode<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"//when called we do recursive calls to next nodes
        } else {//we don't want to print "-> null" with the tail node
            "$value"
        }
    }
}

class LinkedListDinos<T:Any>(){
    private var head : CustomNode<T>? = null
    private var tail : CustomNode<T>? = null
    private var length = 0

    fun append(value : T){
        val newNode = CustomNode<T>(value)
        if(head==null){//the very first element
            head = newNode
        }else{
            tail?.next = newNode
        }
        tail = newNode
        length++
    }

    fun prepend(value : T){
        val newNode = CustomNode<T>(value)
        if(tail==null){//the very first element
            head = newNode
        }else{
            newNode.next = head
        }
        head = newNode
        length++
    }

    fun insert(index: Int,value : T){
        val newNode = CustomNode<T>(value)
        if(index>=length){
            append(value)
        }
        val elementAtIndex = getElementAtIndex(index-1)
        newNode.next = elementAtIndex?.next
        elementAtIndex?.next = newNode
        length++
    }

    fun remove(index:Int){
        val previousNode = getElementAtIndex(index-1)
        val nodeToRemove = previousNode?.next
        previousNode?.next = nodeToRemove?.next
        length--
    }

    private fun getElementAtIndex(index : Int): CustomNode<T>?{
        var currentNode = head
        var counter = index
        while(counter>0){
            currentNode = head?.next
            counter--
        }
        return currentNode
    }

    fun printList(){
        println("My linked list: "+head.toString()+"with length :${length}")
    }

    fun reverse(){
        //check size
        if(length>1){
            var first = head
            tail = head
            var second = first?.next
            while(second!=null){
                val temp = second.next
                second.next = first
                first = second
                second = temp
            }
            head?.next = null
            head = first
        }
    }
}

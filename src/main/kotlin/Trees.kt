import Queue

//General tree implementation
class TreeNode2<T>(val value: T) {
    private val children: MutableList<TreeNode2<T>> = mutableListOf()

    fun add(child: TreeNode2<T>) = children.add(child)

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }
/* using a class that inherits from queue the code works */
    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        //val queue = Queue<TreeNode2<T>>()
        val queue = StackQueue<TreeNode2<T>>()
        children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }


    fun search(value: T): TreeNode2<T>? {
        var result: TreeNode2<T>? = null

        forEachLevelOrder {
            if (it.value == value) {
                result = it
            }
        }

        return result
    }

    fun printEachLevel() {
        // 1
        val queue = ArrayListQueue<TreeNode2<T>>()
        var nodesLeftInCurrentLevel = 0

        queue.enqueue(this)
        // 2
        while (queue.isEmpty.not()) {
            // 3
            nodesLeftInCurrentLevel = queue.count

            // 4
            while (nodesLeftInCurrentLevel > 0) {
                val node = queue.dequeue()
                node?.let {
                    print("${node.value} ")
                    node.children.forEach { queue.enqueue(it) }
                    nodesLeftInCurrentLevel--
                } ?: break
            }

            // 5
            println()
        }
    }


}

typealias Visitor<T> = (TreeNode2<T>) -> Unit





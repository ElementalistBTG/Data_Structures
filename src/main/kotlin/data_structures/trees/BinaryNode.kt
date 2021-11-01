package data_structures.trees

import java.lang.Math.max

typealias Visitor2<T> = (T) -> Unit

class BinaryNode<T : Any>(var value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    override fun toString() = diagram(this)

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    //in order traversal
    fun traverseInOrder(visit: Visitor2<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    //pre order
    fun traversePreOrder(visit: Visitor2<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    //post order
    fun traversePostOrder(visit: Visitor2<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    /*Given a binary tree, find the height of the tree.
    The height of the binary tree is determined by the distance between the root and the furthest leaf.
    The height of a binary tree with a single node is zero since the single node is both the root and the furthest leaf.
     */
    fun height(node: BinaryNode<T>? = this): Int {
        return node?.let {
            1 + max(
                height(node.leftChild),
                height(node.rightChild)
            )
        } ?: -1
    }


}



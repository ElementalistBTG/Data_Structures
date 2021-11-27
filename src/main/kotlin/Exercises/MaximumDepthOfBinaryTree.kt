package Exercises

/**
 *
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
Input: root = [3,9,20,null,null,15,7]
Output: 3
Input: root = [1,null,2]
Output: 2
Input: root = []
Output: 0
 */

class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = maxDepth(root.left) + 1
        val right = maxDepth(root.right) + 1
        return left.coerceAtLeast(right)
    }

    fun maxDepth2(root: TreeNode?): Int {
        return if (root == null) 0 else maxOf(maxDepth(root!!.left), maxDepth(root!!.right)) + 1
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val mClass = MaximumDepthOfBinaryTree()
    val root = TreeNode(1)
    val left = TreeNode(2)
    root.left = left
    left.left = TreeNode(2)
    root.right = TreeNode(3)
    println(mClass.maxDepth(root))
}
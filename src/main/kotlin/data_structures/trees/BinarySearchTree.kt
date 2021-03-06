package data_structures

data class TreeNode(
    val value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

class BinarySearchTree(var root: TreeNode? = null) {
    //insert
    fun insert(value: Int) {
        val myNewTreeNode = TreeNode(value)
        if (root == null) {
            root = myNewTreeNode
        } else {
            var nodeToCompare: TreeNode? = root
            while (true) {
                if (value > nodeToCompare!!.value) {
                    //right
                    if (nodeToCompare.right != null) {
                        nodeToCompare = nodeToCompare.right
                    } else {
                        nodeToCompare.right = myNewTreeNode
                        return
                    }
                } else {
                    //left
                    if (nodeToCompare.left != null) {
                        nodeToCompare = nodeToCompare.left
                    } else {
                        nodeToCompare.left = myNewTreeNode
                        return
                    }
                }
            }
        }

    }

    //lookup
    fun lookup(value: Int): Boolean {
        var nodeToCompare: TreeNode? = root
        while (nodeToCompare != null) {
            nodeToCompare = if (value > nodeToCompare.value) {
                nodeToCompare.right
            } else if (value < nodeToCompare.value) {
                nodeToCompare.left
            } else {
                return true
            }
        }
        return false
    }

    //remove
    fun remove(value: Int): Boolean {
        if (root == null) {
            return false
        }
        var currentNode: TreeNode? = root
        var parentNode: TreeNode? = null
        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode
                currentNode = currentNode.left
            } else if (value > currentNode.value) {
                parentNode = currentNode
                currentNode = currentNode.right
            } else {
                //we have a match

                //option 1: No right child:
                if (currentNode.right == null) {
                    if (parentNode == null) {
                        root = currentNode.left
                    } else {
                        //if parent > current value, make left child a child of parent
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.left
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.left
                        }
                    }
                    //option 2: Right child which doesn't have a left child
                } else if (currentNode.right!!.left == null) {
                    currentNode.right!!.left = currentNode.left
                    if (parentNode == null) {
                        root = currentNode.right
                    } else {
                        //if parent > current, make right child of the left the parent
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.right
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.right
                        }
                    }
                    //option 3: Right child that has a left child
                } else {
                    //find the Right child's left most child
                    var leftmost = currentNode.right!!.left
                    var leftmostParent = currentNode.right
                    while (leftmost?.left != null) {
                        leftmostParent = leftmost
                        leftmost = leftmost.left
                    }
                    //Parent's left subtree is now leftmost's right subtree
                    leftmostParent?.left = leftmost?.right
                    leftmost?.left = currentNode.left
                    leftmost?.right = currentNode.right

                    if (parentNode === null) {
                        root = leftmost
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = leftmost
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = leftmost
                        }
                    }
                }
                return true
            }
        }
        return false
    }

    //show my tree
    fun showTree() {
        println(root)
    }

    // breadth first search
    // note: this function belongs to Algorithms section
    fun breadthFirstSearch(): ArrayList<Int> {
        var currentNode = this.root
        val resultArray = ArrayList<Int>()
        val queue = ArrayList<TreeNode?>()
        queue.add(currentNode)
        while (queue.size > 0) {
            currentNode = queue.removeAt(0)
            resultArray.add(currentNode!!.value)
            if (currentNode.left != null) {
                queue.add(currentNode.left)
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right)
            }
        }
        return resultArray
    }

    // breadth first search recursive
    // note: this function belongs to Algorithms section
    fun breadthFirstSearchRecursive(
        queue: ArrayList<TreeNode?>,
        resultArray: ArrayList<Int>
    ): ArrayList<Int> {
        if (queue.size == 0) {
            return resultArray
        }
        val currentNode = queue.removeAt(0)
        resultArray.add(currentNode!!.value)
        if (currentNode.left != null) {
            queue.add(currentNode.left)
        }
        if (currentNode.right != null) {
            queue.add(currentNode.right)
        }
        return breadthFirstSearchRecursive(queue, resultArray)
    }

    // dfs
    fun DFSInOrder(): ArrayList<Int?> {
        val answer = ArrayList<Int?>()
        return traverseInOrder(this.root, answer)
    }

    fun DFSPreOrder(): ArrayList<Int?> {
        val answer = ArrayList<Int?>()
        return traversePreOrder(this.root, answer)
    }

    fun DFSPostOrder(): ArrayList<Int?> {
        val answer = ArrayList<Int?>()
        return traversePostOrder(this.root, answer)
    }

    private fun traverseInOrder(node: TreeNode?, array: ArrayList<Int?>): ArrayList<Int?> {
        if (node?.left != null) {
            traverseInOrder(node.left, array)
        }
        array.add(node?.value)
        if (node?.right != null) {
            traverseInOrder(node.right, array)
        }
        return array
    }

    private fun traversePreOrder(node: TreeNode?, array: ArrayList<Int?>): ArrayList<Int?> {
        array.add(node?.value)
        if (node?.left != null) {
            traversePreOrder(node.left, array)
        }
        if (node?.right != null) {
            traversePreOrder(node.right, array)
        }
        return array
    }

    private fun traversePostOrder(node: TreeNode?, array: ArrayList<Int?>): ArrayList<Int?> {
        if (node?.left != null) {
            traversePostOrder(node.left, array)
        }
        if (node?.right != null) {
            traversePostOrder(node.right, array)
        }
        array.add(node?.value)
        return array
    }
}

/** Testing */
/*
    val binarySearchTree = `data structures`.BinarySearchTree()
    binarySearchTree.insert(50)
    binarySearchTree.insert(40)
    binarySearchTree.insert(45)
    binarySearchTree.insert(55)
    binarySearchTree.insert(60)
    binarySearchTree.insert(48)
    binarySearchTree.showTree()
    binarySearchTree.remove(40)
    binarySearchTree.showTree()
    binarySearchTree.remove(55)
    binarySearchTree.showTree()
    binarySearchTree.remove(41)
    binarySearchTree.showTree()
 */
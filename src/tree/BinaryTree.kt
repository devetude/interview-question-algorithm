package tree

/**
 * Time Complexity:
 * - Best: O(logn) (balanced tree)
 * - Worst: O(n) (unbalanced tree)
 * Space Complexity: O(n)
 */
fun main() {
    val root = BinaryTree(value = 55).apply {
        left = BinaryTree(value = 30).apply {
            left = BinaryTree(value = 15)
            right = BinaryTree(value = 40)
        }
        right = BinaryTree(value = 70).apply {
            left = BinaryTree(value = 60)
            right = BinaryTree(value = 100)
        }
    }

    val result = buildString {
        appendLine(root.has(value = 70))
        appendLine(root.has(value = 65))
        appendLine(root.add(value = 65))
        appendLine(root.has(value = 65))
        appendLine(root.remove(value = 70))
        appendLine(root.has(value = 70))
        appendLine(root.has(value = 60))
    }

    print(result)
}

private data class BinaryTree<VALUE : Comparable<VALUE>>(val value: VALUE) {
    var left: BinaryTree<VALUE>? = null
    var right: BinaryTree<VALUE>? = null

    fun add(value: VALUE): Boolean {
        var node: BinaryTree<VALUE>? = this
        while (node != null) {
            node = when {
                value < node.value -> {
                    if (node.left == null) {
                        node.left = BinaryTree(value)
                        return true
                    }
                    node.left
                }

                node.value < value -> {
                    if (node.right == null) {
                        node.right = BinaryTree(value)
                        return true
                    }
                    node.right
                }

                else -> return false
            }
        }

        return false
    }

    fun remove(value: VALUE): Boolean {
        var node: BinaryTree<VALUE>? = this
        while (node != null) {
            node = when {
                value < node.value -> {
                    if (node.left?.value == value) {
                        val right = node.left?.right
                        node.left = node.findNewRootOrNull()
                        node.left?.right = right
                        return true
                    }
                    node.left
                }

                node.value < value -> {
                    if (node.right?.value == value) {
                        val left = node.right?.left
                        node.right = node.right?.findNewRootOrNull()
                        node.right?.left = left
                        return true
                    }
                    node.right
                }

                else -> return false
            }
        }

        return false
    }

    private fun findNewRootOrNull(): BinaryTree<VALUE>? =
        when {
            left == null && right == null -> null
            left != null && right == null -> left
            left == null && right != null -> right
            else -> {
                var node = right
                while (node != null) {
                    if (node.left == null) break

                    node = node.left
                }
                node
            }
        }

    fun has(value: VALUE): Boolean {
        var node: BinaryTree<VALUE>? = this
        while (node != null) {
            node = when {
                value < node.value -> node.left
                node.value < value -> node.right
                else -> return true
            }
        }

        return false
    }
}

package tree

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
fun main() {
    data class Node<T>(val value: T) {
        var left: Node<T>? = null
        var right: Node<T>? = null
    }

    val root = Node(value = 1).apply {
        left = Node(value = 2).apply {
            left = Node(value = 4)
            right = Node(value = 5).apply {
                right = Node(value = 8)
            }
        }
        right = Node(value = 3).apply {
            left = Node(value = 6)
            right = Node(value = 7)
        }
    }

    val sb = StringBuilder()
    fun <T> traverse(node: Node<T>) {
        sb.append(node.value, ' ')
        node.left?.let(::traverse)
        node.right?.let(::traverse)
    }
    traverse(root)

    println(sb.toString())
}

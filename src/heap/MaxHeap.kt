package heap

/**
 * Time Complexity:
 * - Offer/Poll: O(logn)
 * - Peek: O(1)
 * Space Complexity: O(n)
 */
fun main() {
    val nums = intArrayOf(1, 3, 2, 4, 1, 3, 5).apply { shuffle() }
    println(nums.joinToString())

    val maxHeap = MaxHeap(nums.size)
    nums.forEach(maxHeap::offer)
    println(maxHeap)

    println(maxHeap.peek())
    repeat(nums.size) {
        println(maxHeap.poll())
        println(maxHeap)
    }
}

private class MaxHeap(capacity: Int) {
    private val tree: IntArray = IntArray(size = capacity shl 1) { Int.MIN_VALUE }
    private var size: Int = 0

    fun offer(x: Int) {
        var current = size + 1
        tree[current] = x

        while (true) {
            val parent = current shr 1
            if (parent == 0 || tree[current] <= tree[parent]) break

            val tmp = tree[parent]
            tree[parent] = tree[current]
            tree[current] = tmp

            current = parent
        }

        ++size
    }

    fun poll(): Int {
        check(0 < size)

        val peek = peek()
        tree[1] = tree[size]
        tree[size] = Int.MIN_VALUE
        --size
        var current = 1

        while (current < size) {
            val left = current shl 1
            val right = left + 1

            if (tree[right] < tree[left]) {
                if (tree[current] < tree[left]) {
                    val tmp = tree[current]
                    tree[current] = tree[left]
                    tree[left] = tmp
                    current = left
                } else {
                    break
                }
            } else {
                if (tree[current] < tree[right]) {
                    val tmp = tree[current]
                    tree[current] = tree[right]
                    tree[right] = tmp
                    current = right
                } else {
                    break
                }
            }
        }

        return peek
    }

    fun peek(): Int {
        check(0 < size)

        return tree[1]
    }

    override fun toString(): String = buildString {
        for (i in 1..size) append(tree[i], ' ')
    }
}

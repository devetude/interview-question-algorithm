package graph

import java.util.LinkedList

private val parentOf: IntArray = IntArray(size = 8) { it }

fun main() {
    val adjacencyList = Array(size = 8) { LinkedList<Int>() }.apply {
        this[1].add(2)
        this[2].add(1)

        this[2].add(6)
        this[6].add(2)

        this[3].add(4)
        this[4].add(3)

        this[3].add(5)
        this[5].add(3)

        this[4].add(7)
        this[7].add(4)

        this[5].add(7)
        this[7].add(5)
    }
    println("adjacencyList=${adjacencyList.joinToString()}")

    for (u in 1..7) adjacencyList[u].forEach { v -> union(u, v) }
    println("parentOf=${parentOf.joinToString()}")

    val groupSize = parentOf.toSet().size - 1
    println("groupSize=$groupSize")
}

private fun union(u: Int, v: Int) {
    val parentOfU = find(u)
    val parentOfV = find(v)
    if (parentOfU == parentOfV) return

    if (parentOfU < parentOfV) {
        parentOf[parentOfV] = parentOfU
    } else {
        parentOf[parentOfU] = parentOfV
    }
}

private fun find(u: Int): Int =
    if (parentOf[u] == u) u else find(parentOf[u]).also { parentOf[u] = it }

package graph

import java.util.LinkedList

/**
 * Time Complexity:
 * - Adjacency List: O(v+e) (v = vertex, e = edge)
 * - Adjacency Matrix: O(v^2) (v = vertex)
 *
 * Space Complexity:
 * - Adjacency List: O(v+e) (v = vertex, e = edge)
 * - Adjacency Matrix: O(v^2) (v = vertex)
 */
fun main() {
    val weightBetween = Array(size = 10) { LinkedList<Pair<Int, Int>>() }
        .apply {
            addBiDirection(u = 1, v = 2, w = 1)
            addBiDirection(u = 2, v = 3, w = 2)
            addBiDirection(u = 3, v = 7, w = 5)
            addBiDirection(u = 7, v = 5, w = 9)
            addBiDirection(u = 3, v = 9, w = 3)
        }

    val isVisited = BooleanArray(size = 10).apply { this[1] = true }
    val nextNodes = LinkedList<Pair<Int, Int>>().apply { add(1 to 0) }
    while (nextNodes.isNotEmpty()) {
        val (u, weight) = nextNodes.poll()
        println("$u, $weight")

        weightBetween[u].forEach { (v, weight) ->
            if (isVisited[v]) return@forEach

            isVisited[v] = true
            nextNodes.offer(v to weight)
        }
    }
}

private fun Array<LinkedList<Pair<Int, Int>>>.addBiDirection(u: Int, v: Int, w: Int) {
    this[u].add(v to w)
    this[v].add(u to w)
}

package graph

import java.util.LinkedList

/**
 * Time Complexity:
 * - Add: O(1)
 * - Search, Remove: O(d(v)) (d = degree, v = vertex)
 * Space Complexity: O(v+e) (v = vertex, e = edge)
 */
fun main() {
    val weightBetween = Array(size = 10) { LinkedList<Pair<Int, Int>>() }
        .apply {
            addBiDirection(u = 1, v = 2, w = 1)
            addBiDirection(u = 2, v = 3, w = 2)
            addBiDirection(u = 3, v = 7, w = 5)
            addBiDirection(u = 3, v = 9, w = 3)
        }

    for (u in weightBetween.indices) {
        weightBetween[u].forEach { (v, weight) ->
            if (weight < Int.MAX_VALUE) println("$u > $v : $weight")
        }
    }
}

private fun Array<LinkedList<Pair<Int, Int>>>.addBiDirection(u: Int, v: Int, w: Int) {
    this[u].add(v to w)
    this[v].add(u to w)
}

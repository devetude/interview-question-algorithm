package graph

import java.util.LinkedList

private val weightBetween: Array<LinkedList<Pair<Int, Int>>> =
    Array(size = 10) { LinkedList<Pair<Int, Int>>() }
private val isVisited: BooleanArray = BooleanArray(size = 10)

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
    weightBetween.apply {
        addBiDirection(u = 1, v = 2, w = 1)
        addBiDirection(u = 2, v = 3, w = 2)
        addBiDirection(u = 3, v = 7, w = 5)
        addBiDirection(u = 7, v = 5, w = 9)
        addBiDirection(u = 3, v = 9, w = 3)
    }

    isVisited[1] = true
    dfs(u = 1, weight = 0)
}

private fun Array<LinkedList<Pair<Int, Int>>>.addBiDirection(u: Int, v: Int, w: Int) {
    this[u].add(v to w)
    this[v].add(u to w)
}

private fun dfs(u: Int, weight: Int) {
    println("$u, $weight")

    weightBetween[u].forEach { (v, weight) ->
        if (isVisited[v]) return@forEach

        isVisited[v] = true
        dfs(v, weight)
    }
}

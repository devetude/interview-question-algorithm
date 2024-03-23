package graph

private const val INF: Int = Int.MAX_VALUE shr 1

/**
 * Time Complexity: O(v*e) (v = vertex, e = edge)
 * Space Complexity: O(e) (e = edge)
 */
fun main() {
    val edges = arrayOf(
        Triple(first = 0, second = 1, third = 4),
        Triple(first = 0, second = 2, third = 3),
        Triple(first = 1, second = 2, third = -2),
        Triple(first = 1, second = 3, third = 1),
        Triple(first = 2, second = 3, third = 5),
        Triple(first = 2, second = 4, third = 2),
        Triple(first = 4, second = 3, third = -6)
    )

    val minDistanceTo = IntArray(size = 5) { INF }.apply { this[0] = 0 }
    repeat(times = 5) {
        edges.forEach { (u, v, distance) ->
            if (minDistanceTo[u] != INF && minDistanceTo[u] + distance < minDistanceTo[v]) {
                minDistanceTo[v] = minDistanceTo[u] + distance
            }
        }
    }

    edges.forEach { (u, v, distance) ->
        if (minDistanceTo[u] != INF && minDistanceTo[u] + distance < minDistanceTo[v]) {
            return println("cycle")
        }
    }

    println(minDistanceTo.joinToString())
}

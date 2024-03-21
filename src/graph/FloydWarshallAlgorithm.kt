package graph

private const val INF: Int = 999_999

/**
 * Time Complexity: O(v^3) (v = vertex)
 * Space Complexity: O(v^2) (v = vertex)
 */
fun main() {
    val adjacencyMatrix = Array(size = 6) { IntArray(size = 6) { INF } }.apply {
        addBiDirection(u = 1, v = 1, w = 0)
        addBiDirection(u = 1, v = 2, w = 4)
        addBiDirection(u = 1, v = 3, w = 1)
        addBiDirection(u = 1, v = 4, w = 1)
        addBiDirection(u = 2, v = 2, w = 0)
        addBiDirection(u = 2, v = 5, w = 8)
        addBiDirection(u = 3, v = 3, w = 0)
        addBiDirection(u = 3, v = 4, w = 3)
        addBiDirection(u = 3, v = 5, w = 15)
        addBiDirection(u = 4, v = 4, w = 0)
        addBiDirection(u = 4, v = 5, w = 6)
        addBiDirection(u = 5, v = 5, w = 0)
    }
    print(adjacencyMatrix)

    for (v in 1..5) {
        for (u in 1..5) {
            for (t in 1..5) {
                adjacencyMatrix[u][t] = minOf(
                    adjacencyMatrix[u][t],
                    b = adjacencyMatrix[u][v] + adjacencyMatrix[v][t]
                )
            }
        }
    }
    print(adjacencyMatrix)
}

private fun Array<IntArray>.addBiDirection(u: Int, v: Int, w: Int) {
    this[u][v] = w
    this[v][u] = w
}

private fun print(adjacencyMatrix: Array<IntArray>) {
    val text = buildString {
        for (u in 1..5) {
            for (v in 1..5) {
                append(adjacencyMatrix[u][v], ' ')
            }
            appendLine()
        }
    }

    System.out.bufferedWriter().use {
        it.write(text)
        it.flush()
    }
}

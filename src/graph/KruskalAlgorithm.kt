package graph

/**
 * Time Complexity:
 * - Union-Find: O(eloge) (e = edge)
 * - Flood-Fill: O(eloge + ve) (e = edge, v = vertex)
 *
 * Space Complexity: O(e) (e = edge)
 */
fun main() {
    val edges = mutableListOf(
        Triple(first = 1, second = 3, third = 3),
        Triple(first = 1, second = 4, third = 3),
        Triple(first = 2, second = 5, third = 8),
        Triple(first = 3, second = 1, third = 4),
        Triple(first = 3, second = 4, third = 3),
        Triple(first = 3, second = 5, third = 5),
        Triple(first = 4, second = 5, third = 6)
    ).apply { sortByWeight() }
    println("edges=${edges.joinToString()}")

    val selectedEdges = mutableListOf<Triple<Int, Int, Int>>()
    for (i in 0 until edges.lastIndex) {
        val (u, v, w) = edges[i]
        union()
        if (find(u) == find(v)) continue

        selectedEdges.add(edges[i])
    }
    println("selectedEdges=${selectedEdges.joinToString()}")
}

private fun MutableList<Triple<Int, Int, Int>>.sortByWeight() = sortWith(
    compareBy<Triple<Int, Int, Int>> { it.third }.thenBy { it.first }.thenBy { it.second }
)

private fun union() {
    // TODO: Implement here.
}

private fun find(u: Int): Int {
    // TODO: Implement here.
    return -1
}


package graph

private val parentOf: IntArray = IntArray(size = 6) { it }

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
        Triple(first = 1, second = 2, third = 4),
        Triple(first = 1, second = 4, third = 3),
        Triple(first = 2, second = 5, third = 8),
        Triple(first = 3, second = 4, third = 3),
        Triple(first = 3, second = 5, third = 5),
        Triple(first = 4, second = 5, third = 6)
    ).apply { sortByWeight() }
    println("edges=${edges.joinToString()}")

    val selectedEdges = mutableListOf<Triple<Int, Int, Int>>()
    for (i in edges.indices) {
        val (u, v, _) = edges[i]
        if (isCycleCreatedBy(u, v)) continue

        selectedEdges.add(edges[i])
        if (selectedEdges.size == edges.size - 1) break
    }
    println("selectedEdges=${selectedEdges.joinToString()}")

    val minWeightSum = selectedEdges.sumOf { it.third }
    println(minWeightSum)
}

private fun MutableList<Triple<Int, Int, Int>>.sortByWeight() = sortWith(
    compareBy<Triple<Int, Int, Int>> { it.third }.thenBy { it.first }.thenBy { it.second }
)

private fun isCycleCreatedBy(u: Int, v: Int): Boolean {
    val parentOfU = find(u)
    val parentOfV = find(v)
    if (parentOfU == parentOfV) return true

    parentOf[v] = parentOfU

    return false
}

private fun find(u: Int): Int =
    if (parentOf[u] == u) u else find(parentOf[u]).also { parentOf[u] = it }


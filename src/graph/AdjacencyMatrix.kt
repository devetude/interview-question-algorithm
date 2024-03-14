package graph

/**
 * Time Complexity: O(1)
 * Space Complexity: O(v^2) (v = vertex)
 */
fun main() {
    val weightBetween = Array(size = 10) { IntArray(size = 10) { Int.MAX_VALUE } }
        .apply {
            addBiDirection(u = 1, v = 2, w = 1)
            addBiDirection(u = 2, v = 3, w = 2)
            addBiDirection(u = 3, v = 7, w = 5)
            addBiDirection(u = 3, v = 9, w = 3)
        }

    for (u in weightBetween.indices) {
        for (v in weightBetween[u].indices) {
            val weight = weightBetween[u][v]
            if (weight < Int.MAX_VALUE) println("$u > $v : $weight")
        }
    }
}

private fun Array<IntArray>.addBiDirection(u: Int, v: Int, w: Int) {
    this[u][v] = w
    this[v][u] = w
}

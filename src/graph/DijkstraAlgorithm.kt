package graph

import java.util.LinkedList
import java.util.PriorityQueue

/**
 * Time Complexity: O(elogv) (v = vertex, e = edge)
 * Space Complexity: O(v+e) (v = vertex, e = edge)
 */
fun main() {
    val adjacencyList = Array(size = 7) { LinkedList<Pair<Int, Int>>() }.apply {
        this[1].add(2 to 3)
        this[1].add(3 to 2)
        this[1].add(4 to 5)
        this[2].add(3 to 2)
        this[2].add(5 to 8)
        this[3].add(4 to 2)
        this[4].add(5 to 6)
        this[5].add(6 to 1)
    }

    val minDistanceTo = IntArray(size = 7) { Int.MAX_VALUE }.apply { this[1] = 0 }
    val nextNodes = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }).apply { offer(1 to 0) }
    while (nextNodes.isNotEmpty()) {
        val (u, distance) = nextNodes.poll()
        if (minDistanceTo[u] < distance) continue

        adjacencyList[u].forEach { (v, distance) ->
            val distanceToV = minDistanceTo[u] + distance
            if (minDistanceTo[v] <= distanceToV) return@forEach

            minDistanceTo[v] = distanceToV
            nextNodes.offer(v to distanceToV)
        }
    }

    println(minDistanceTo.joinToString())
}

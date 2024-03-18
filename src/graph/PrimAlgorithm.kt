package graph

import java.util.LinkedList
import java.util.PriorityQueue

/**
 * Time Complexity: O(eloge) (e = edge)
 * Space Complexity: O(v+e) (v = vertex, e = edge)
 */
fun main() {
    val adjacencyList = Array(size = 6) { LinkedList<Pair<Int, Int>>() }.apply {
        this[1].add(3 to 3)
        this[1].add(2 to 4)
        this[1].add(4 to 3)
        this[2].add(5 to 8)
        this[3].add(4 to 3)
        this[3].add(5 to 5)
        this[4].add(5 to 6)
    }
    println("adjacencyList=${adjacencyList.joinToString()}")

    val isSelected = BooleanArray(size = 6).apply { this[1] = true }

    val nextEdges = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
    adjacencyList[1].forEach { (v, w) ->
        val nextEdge = Triple(first = 1, v, w)
        nextEdges.offer(nextEdge)
    }

    val selectedEdges = mutableListOf<Triple<Int, Int, Int>>()
    while (selectedEdges.size < 4) {
        val edge = nextEdges.poll()
        if (isSelected[edge.second]) continue

        isSelected[edge.second] = true
        selectedEdges.add(edge)
        adjacencyList[edge.second].forEach { (v, w) ->
            if (isSelected[v]) return@forEach

            val nextEdge = Triple(edge.second, v, w)
            nextEdges.offer(nextEdge)
        }
    }
    println("selectedEdges=${selectedEdges.joinToString()}")

    val minWeightSum = selectedEdges.sumOf { it.third }
    println("minWeightSum=$minWeightSum")
}

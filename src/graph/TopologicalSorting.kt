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
    val indegreeOf = IntArray(size = 8)
    val adjacencyList = Array(size = 8) { LinkedList<Int>() }.apply {
        this[1].add(2)
        ++indegreeOf[2]

        this[3].add(2)
        ++indegreeOf[2]

        this[3].add(4)
        ++indegreeOf[4]

        this[4].add(2)
        ++indegreeOf[2]

        this[4].add(5)
        ++indegreeOf[5]

        this[5].add(6)
        ++indegreeOf[6]

        this[7].add(5)
        ++indegreeOf[5]
    }

    println("adjacencyList=${adjacencyList.joinToString()}")
    println("indegreeOf=${indegreeOf.joinToString()}")

    val result = mutableListOf<Int>()
    val nextNodes = LinkedList<Int>().apply {
        for (u in 1..7) if (indegreeOf[u] == 0) add(u)
    }
    while (nextNodes.isNotEmpty()) {
        val u = nextNodes.poll()
        result.add(u)

        adjacencyList[u].forEach { v ->
            --indegreeOf[v]
            if (indegreeOf[v] == 0) nextNodes.offer(v)
        }
    }

    println("result=$result")
}

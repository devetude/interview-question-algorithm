package sort

import java.util.LinkedList

/**
 * Time Complexity: O(dn)
 * Space Complexity: O(n)
 */
fun main() {
    val arr = intArrayOf(0, 1, 2, 21, 22, 34, 41, 47, 5, 6, 77, 79, 80, 81, 999).apply { shuffle() }
    println(arr.joinToString())

    val maxLen = 3
    var buckets = Array(size = 10) { LinkedList<Int>() }
    for (n in 1..maxLen) {
        arr.forEach { buckets[it.digitOf(n)].add(it) }
        var j = 0
        buckets.forEach { it.forEach { num -> arr[j++] = num } }
        buckets = Array(size = 10) { LinkedList<Int>() }
    }
    println(arr.joinToString())
}

private fun Int.digitOf(n: Int): Int {
    require(1 <= n)
    val div = generateSequence(seed = 1) { it * 10 }.take(n).last()
    return this / div % 10
}

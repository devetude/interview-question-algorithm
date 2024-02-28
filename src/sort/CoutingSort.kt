package sort

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
fun main() {
    val arr = intArrayOf(0, 1, 2, 2, 3, 3, 4, 4, 4, 5, 6, 7, 7, 8, 8, 8, 9, 9).apply { shuffle() }
    println(arr.joinToString())

    val counts = IntArray(size = 10)
    arr.forEach { ++counts[it] }
    var j = 0
    counts.forEachIndexed { i, count -> repeat(count) { arr[j++] = i } }
    println(arr.joinToString())
}

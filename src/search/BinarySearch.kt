package search

/**
 * Time Complexity:
 * - Sorted: O(logn)
 * - Unsorted: O(nlogn)
 * Space Complexity: O(n)
 */
fun main() {
    val arr = intArrayOf(-5, 3, 1, 2, 1, 0, 2, 4, 4, 6, -5, 7).apply { shuffle() }

    println(arr.lowerBound(x = 4))
    println(arr.upperBound(x = 4))
}

private fun IntArray.lowerBound(x: Int): Int {
    val sortedArr = sorted()
    println(sortedArr.joinToString())

    var low = 0
    var high = size
    while (low < high) {
        val mid = low + high shr 1
        if (sortedArr[mid] < x) low = mid + 1 else high = mid
    }

    return high
}

private fun IntArray.upperBound(x: Int): Int {
    val sortedArr = sorted()
    println(sortedArr.joinToString())

    var low = 0
    var high = size
    while (low < high) {
        val mid = low + high shr 1
        if (sortedArr[mid] <= x) low = mid + 1 else high = mid
    }

    return high
}

package sort

private val arr: MutableList<Int> = (-5..5).toMutableList().apply { shuffle() }

/**
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */
fun main() {
    println(arr.joinToString())
    quickSort(start = 0, end = arr.size)
    println(arr.joinToString())
}

fun quickSort(start: Int, end: Int) {
    if (end - 1 <= start) return

    val pivot = arr[start]
    var left = start + 1
    var right = end - 1
    while (true) {
        while (left <= right && arr[left] <= pivot) ++left
        while (left <= right && pivot <= arr[right]) --right
        if (right < left) break

        val tmp = arr[left]
        arr[left] = arr[right]
        arr[right] = tmp
    }
    arr[start] = arr[right]
    arr[right] = pivot

    quickSort(start, right)
    quickSort(right + 1, end)
}

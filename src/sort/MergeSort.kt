package sort

private val arr: MutableList<Int> = (-5..5).toMutableList().apply { shuffle() }
private val tmp: IntArray = IntArray(arr.size)

/**
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */
fun main() {
    println(arr.joinToString())
    mergeSort(start = 0, end = arr.size)
    println(arr.joinToString())
}

fun mergeSort(start: Int, end: Int) {
    if (start == end - 1) return

    val mid = start + end shr 1
    mergeSort(start, mid)
    mergeSort(mid, end)
    merge(start, end)
}

fun merge(start: Int, end: Int) {
    val mid = start + end shr 1
    var left = start
    var right = mid
    for (i in start until end) {
        tmp[i] = when {
            right == end -> arr[left++]
            left == mid -> arr[right++]
            arr[left] <= arr[right] -> arr[left++]
            else -> arr[right++]
        }
    }
    for (i in start until end) arr[i] = tmp[i]
}

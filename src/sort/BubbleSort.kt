package sort

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
fun main() {
    val arr = (-5..5).toMutableList().apply { shuffle() }
    println(arr.joinToString())

    for (i in arr.lastIndex downTo 1) {
        for (j in 0 until i) {
            if (arr[j] <= arr[j + 1]) continue

            val tmp = arr[j]
            arr[j] = arr[j + 1]
            arr[j + 1] = tmp
        }
    }
    println(arr.joinToString())
}

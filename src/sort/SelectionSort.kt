package sort

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
fun main() {
    val arr = (-5..5).toMutableList().apply { shuffle() }
    println(arr.joinToString())

    for (i in 0 until arr.lastIndex) {
        for (j in i + 1 until arr.size) {
            if (arr[i] <= arr[j]) continue

            val tmp = arr[i]
            arr[i] = arr[j]
            arr[j] = tmp
        }
    }
    println(arr.joinToString())
}

package sort

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
fun main() {
    val arr = (-5..5).toMutableList().apply { shuffle() }
    println(arr.joinToString())

    for (i in 1 until arr.size) {
        val target = arr[i]
        var j = i - 1
        while (0 <= j && target < arr[j]) {
            arr[j + 1] = arr[j]
            --j
        }
        arr[j + 1] = target
    }
    println(arr.joinToString())
}

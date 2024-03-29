package array

/**
 * Time Complexity:
 * - Get: O(1)
 * - Add, Remove: O(n)
 * Space Complexity: O(n)
 */
fun main() {
    val arr = IntArray(size = 10) { it }
    println("arr=${arr.joinToString()}")

    arr.add(i = 5, num = 100)
    println("arr=${arr.joinToString()}")

    arr.remove(i = 5)
    println("arr=${arr.joinToString()}")
}

private fun IntArray.add(i: Int, num: Int) {
    for (j in lastIndex - 1 downTo i) this[j + 1] = this[j]
    this[i] = num
}

private fun IntArray.remove(i: Int) {
    for (j in i + 1..lastIndex) this[j - 1] = this[j]
}

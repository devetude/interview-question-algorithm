package search

/**
 * Time Complexity:
 * - Sorted: O(logn)
 * - Unsorted: O(nlogn)
 * Space Complexity: O(n)
 */
fun main() {
    // Q. Get the maximum upper bound budget.
    val requestedBudgets = intArrayOf(70, 80, 30, 40, 100)
    val budget = 450

    requestedBudgets.sort()
    var min = 1
    var max = requestedBudgets.last()
    while (min <= max) {
        val mid = min + max shr 1
        val sum = requestedBudgets.sumOf { if (mid < it) mid else it }
        if (budget < sum) {
            max = mid - 1
        } else {
            min = mid + 1
        }
    }

    print(max)
}

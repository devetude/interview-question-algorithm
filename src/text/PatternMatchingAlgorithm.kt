package text

/**
 * Time Complexity: O(tk) (t = text, k = keyword)
 * Space Complexity: O(l) (l = text length)
 */
fun main() {
    val text = "aaaaaaaaaaaa"
    val pattern = "aaaaab"

    for (i in 0 until text.length - pattern.length) {
        var isMatched = true
        for (j in pattern.indices) {
            if (text[i + j] == pattern[j]) continue

            isMatched = false
            break
        }
        if (isMatched) return println("isMatched")
    }

    println("isUnmatched")
}

package text

fun main() {
    val text = "abababadababacabad"
    val pattern = "ababacaba"

    val failOf = IntArray(text.length)
    var j = 0
    for (i in 1 until text.length) {
        while (0 < j && text[i] != text[j]) j = failOf[j - 1]
        if (text[i] == text[j]) failOf[i] = ++j
    }
    println("failOf=${failOf.joinToString()}")

    j = 0
    for (i in text.indices) {
        while (0 < j && text[i] != pattern[j]) j = failOf[j - 1]
        if (text[i] == pattern[j]) ++j
        if (j == pattern.length) return println("index=${j - 1}")
    }

    println("index=-1")
}

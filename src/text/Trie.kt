package text

/**
 * Time Complexity: O(l) (l = text length)
 * Space Complexity: O(nl) (n = text size, l = text length)
 */
fun main() {
    val result = buildString {
        with(Trie()) {
            appendLine(add(text = "apple"))
            appendLine(add(text = "apple"))
            appendLine(add(text = "application"))
            appendLine(add(text = "banana"))
            appendLine(add(text = "bananas"))
            appendLine(add(text = "car"))
            appendLine(size())
            appendLine(has(text = "apple"))
            appendLine(has(text = "app"))
            appendLine(has(text = "applications"))
            appendLine(remove(text = "banana"))
            appendLine(remove(text = "banana"))
            appendLine(size())
            appendLine(has(text = "banana"))
            appendLine(has(text = "bananas"))
        }
    }

    print(result)
}

private data class Trie(val c: Char = ' ') {
    private val children: HashMap<Char, Trie> = hashMapOf()
    private var isTerminal: Boolean = false
    private var size: Int = 0

    fun add(text: String): Boolean {
        var trie = this
        text.forEach {
            if (trie.children[it] == null) trie.children[it] = Trie(it)
            trie = requireNotNull(trie.children[it])
        }
        if (trie.isTerminal) return false

        trie.isTerminal = true
        ++size

        return true
    }

    fun remove(text: String): Boolean {
        var trie = this
        text.forEach {
            if (trie.children[it] == null) return false
            trie = requireNotNull(trie.children[it])
        }
        if (!trie.isTerminal) return false

        trie.isTerminal = false
        --size

        return true
    }

    fun has(text: String): Boolean {
        var trie = this
        text.forEach {
            if (trie.children[it] == null) return false
            trie = requireNotNull(trie.children[it])
        }

        return trie.isTerminal
    }

    fun size(): Int = size
}

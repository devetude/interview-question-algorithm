package hash

import java.util.LinkedList

/**
 * Time Complexity:
 * - Best: O(1)
 * - Worst: O(n)
 * Space Complexity: O(mn) (m = bucket, n = entry)
 */
fun main() {
    val map = SeparateChainingHashMap<String, Int>()
    map.add(key = "apple", value = 1)
    map.add(key = "banana", value = 2)
    map.add(key = "orange", value = 3)
    map.add(key = "orange", value = 0)
    println(map)

    map.remove(key = "apple")
    println(map)
    println(map.size())
    println(map.get(key = "orange"))
}

class SeparateChainingHashMap<KEY, VALUE> {
    private var buckets: Array<LinkedList<Entry<KEY, VALUE>>> = Array(BUCKET_SIZE) { LinkedList() }
    private var entrySize: Int = 0

    fun add(key: KEY, value: VALUE): Boolean {
        val bucket = bucketOf(key)
        val entry = bucket.find { it.key == key }
        if (entry != null) {
            entry.value = value
            return false
        }

        bucket.add(Entry(key, value))
        ++entrySize
        return true
    }

    fun remove(key: KEY): Boolean {
        val bucket = bucketOf(key)
        val i = bucket.indexOfFirst { it.key == key }
        if (i < 0) return false

        bucket.removeAt(i)
        --entrySize
        return true
    }

    fun get(key: KEY): VALUE? = bucketOf(key).find { it.key == key }?.value

    fun size(): Int = entrySize

    private fun bucketOf(key: KEY): LinkedList<Entry<KEY, VALUE>> {
        val i = (BUCKET_SIZE + key.hashCode() % BUCKET_SIZE) % BUCKET_SIZE
        return buckets[i]
    }

    override fun toString(): String = buckets.filter { it.isNotEmpty() }.flatten().joinToString()

    private data class Entry<KEY, VALUE>(val key: KEY, var value: VALUE)

    companion object {
        private const val BUCKET_SIZE: Int = 31
    }
}

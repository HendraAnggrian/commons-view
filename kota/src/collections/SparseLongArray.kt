@file:JvmMultifileClass
@file:JvmName("SparseArraysKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED", "EXTENSION_SHADOWED_BY_MEMBER")

package kota

import android.support.annotation.RequiresApi
import android.util.SparseLongArray
import java.util.*

/** Transform current map to sparse array. */
@RequiresApi(18) inline fun Map<Int, Long>.toSparseLongArray(): SparseLongArray = SparseLongArray().apply {
    for (key in keys) append(key, get(key))
}

/** Returns an empty sparse array. */
@RequiresApi(18) inline fun sparseLongArrayOf(): SparseLongArray = SparseLongArray()

/** Returns a sparse array with matching position of array input. */
@RequiresApi(18) inline fun sparseLongArrayOf(vararg elements: Long): SparseLongArray = SparseLongArray().apply {
    var i = 0
    for (element in elements) append(i++, element)
}

/** Returns a sparse array with defined position and element from Kotlin pair. */
@RequiresApi(18) inline fun sparseLongArrayOf(vararg pairs: Pair<Int, Long>): SparseLongArray = SparseLongArray().apply {
    for ((key, value) in pairs) append(key, value)
}

@RequiresApi(18) inline operator fun SparseLongArray.get(key: Int): Long = get(key)
@RequiresApi(18) inline operator fun SparseLongArray.set(key: Int, value: Long) = put(key, value)

@RequiresApi(18) inline fun SparseLongArray.containsKey(key: Int): Boolean = indexOfKey(key) > -1
@RequiresApi(18) inline fun SparseLongArray.containsValue(value: Long): Boolean = indexOfValue(value) > -1

@RequiresApi(18) inline fun SparseLongArray.forEach(action: (Long) -> Unit) {
    val size = size()
    for (i in 0 until size) {
        if (size != size()) throw ConcurrentModificationException()
        action(valueAt(i))
    }
}

@RequiresApi(18) inline fun SparseLongArray.forEachIndexed(action: (Int, Long) -> Unit) {
    val size = size()
    for (i in 0 until size) {
        if (size != size()) throw ConcurrentModificationException()
        action(keyAt(i), valueAt(i))
    }
}
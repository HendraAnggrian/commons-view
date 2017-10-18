@file:JvmMultifileClass
@file:JvmName("SpansKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kota.texts

import android.text.SpannableStringBuilder
import android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE

/** Returns a new [SpannableStringBuilder] from [source] or the [source] itself if it is already an instance of [SpannableStringBuilder]. */
inline fun spannableBuilderOf(source: CharSequence, flags: Int, vararg spans: Any): SpannableStringBuilder = SpannableStringBuilder.valueOf(source).apply { setSpans(flags, *spans) }

inline fun spannableBuilderOf(source: CharSequence, vararg spans: Any): SpannableStringBuilder = SpannableStringBuilder.valueOf(source).apply { setSpans(*spans) }

/** Append text with [spans] applied. */
inline fun SpannableStringBuilder.append(flags: Int, text: CharSequence, vararg spans: Any): SpannableStringBuilder {
    append(text)
    val end = length
    val start = end - text.length
    spans.forEach { setSpan(it, start, end, flags) }
    return this
}

/** Append text with [spans] applied using default flags. */
inline fun SpannableStringBuilder.append(text: CharSequence, vararg spans: Any): SpannableStringBuilder = append(SPAN_EXCLUSIVE_EXCLUSIVE, text, *spans)
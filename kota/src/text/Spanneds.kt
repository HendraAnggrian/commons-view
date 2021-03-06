@file:JvmMultifileClass
@file:JvmName("TextsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kota

import android.support.annotation.RequiresApi
import android.text.Html
import android.text.Html.fromHtml
import android.text.Html.toHtml
import android.text.Spanned
import android.text.SpannedString
import android.text.SpannedString.valueOf

/** Returns a new [SpannedString] from source or the source itself if it is already an instance of [SpannedString]. */
inline fun CharSequence.toSpanned(): Spanned = valueOf(this)

@JvmOverloads
@RequiresApi(24)
inline fun String.toSpanned(flags: Int, imageGetter: Html.ImageGetter? = null, tagHandler: Html.TagHandler? = null): Spanned = fromHtml(this, flags, imageGetter, tagHandler)

@RequiresApi(24)
inline fun Spanned.toHtml(option: Int): String = toHtml(this, option)

/** Get all spans that are instance of [type]. */
inline fun <reified T> Spanned.getSpans(type: Class<T>): Array<out T> = getSpans(0, length, type)

/** Get all spans attached from this text. */
inline val Spanned.spans: Array<out Any> get() = getSpans(Any::class.java)
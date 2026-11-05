package com.android.purebilibili.feature.video.player

import android.net.Uri
import com.android.purebilibili.core.util.FormatUtils
import java.util.concurrent.atomic.AtomicLong

private val sessionArtworkGeneration = AtomicLong()

/**
 * Media3 caches the last session artwork bitmap and reuses that instance.
 * Some Android builds recycle it inside MediaMetadata.Builder.scaleBitmap, so the
 * next metadata update crashes with "cannot use a recycled source in createBitmap".
 * A new fragment forces a new bitmap. The fragment is not part of the image request.
 */
fun sessionArtworkUri(
    coverUrl: String,
    generation: Long = sessionArtworkGeneration.incrementAndGet(),
): Uri = Uri.parse(sessionArtworkUriString(coverUrl, generation))

fun sessionArtworkUriString(coverUrl: String, generation: Long): String {
    val fixed = FormatUtils.fixImageUrl(coverUrl).substringBefore('#')
    return "$fixed#bilipai-art-$generation"
}

package com.android.purebilibili.feature.video.player

/**
 * Media3 wraps every session [androidx.media3.common.util.BitmapLoader] with
 * SizeLimitedBitmapLoader(makeShared = true) and CacheBitmapLoader. On some OEM
 * builds (OxygenOS / Android 15 observed), MediaMetadata.Builder.scaleBitmap then
 * recycles that shared bitmap, and the next metadata publish crashes with
 * "cannot use a recycled source in createBitmap".
 *
 * Session metadata therefore omits artwork. Notification large icons still load
 * through Coil in MiniPlayerManager and do not go through MediaSession.setMetadata.
 */
fun shouldAttachMediaSessionArtwork(): Boolean = false

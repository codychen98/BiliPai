package com.android.purebilibili.feature.video.player

import kotlin.test.Test
import kotlin.test.assertFalse

class SessionArtworkUriTest {
    @Test
    fun mediaSessionArtworkStaysDisabledOnOemRecycleBuilds() {
        assertFalse(shouldAttachMediaSessionArtwork())
    }
}

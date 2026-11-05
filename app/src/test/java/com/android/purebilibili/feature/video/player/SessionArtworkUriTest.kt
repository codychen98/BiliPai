package com.android.purebilibili.feature.video.player

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class SessionArtworkUriTest {
    @Test
    fun eachPublishUsesADistinctFragmentAndTheSameImageRequest() {
        val cover = "//i0.hdslb.com/bfs/archive/demo.jpg@672w_378h.webp"
        val first = sessionArtworkUriString(cover, 1)
        val second = sessionArtworkUriString(cover, 2)

        assertEquals("https://i0.hdslb.com/bfs/archive/demo.jpg#bilipai-art-1", first)
        assertEquals("https://i0.hdslb.com/bfs/archive/demo.jpg#bilipai-art-2", second)
        assertNotEquals(first, second)
        assertEquals(first.substringBefore('#'), second.substringBefore('#'))
    }

    @Test
    fun anExistingFragmentIsReplaced() {
        assertEquals(
            "https://i0.hdslb.com/bfs/archive/demo.jpg?x=1#bilipai-art-7",
            sessionArtworkUriString("https://i0.hdslb.com/bfs/archive/demo.jpg?x=1#old", 7),
        )
    }
}

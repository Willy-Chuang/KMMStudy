package com.willychuang.kmmstudy.shared.service

import com.willychuang.kmmstudy.shared.GdgLogger
import com.willychuang.kmmstudy.shared.module.Albums
import com.willychuang.kmmstudy.shared.service.api.SpotifyApi

class SpotifyService {
    companion object {
        internal val TAG = SpotifyService::class.simpleName ?: ""
    }

    private val api = SpotifyApi()

    suspend fun getAlbums(): Albums {
        api.getAlbums().also {
            GdgLogger.i(TAG, it.toString())
            return it
        }
    }

}
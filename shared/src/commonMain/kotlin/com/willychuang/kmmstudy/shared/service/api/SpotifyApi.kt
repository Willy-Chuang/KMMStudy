package com.willychuang.kmmstudy.shared.service.api

import com.willychuang.kmmstudy.shared.module.Albums
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class SpotifyApi {
    companion object {
        private const val SPOTIFY_ENDPOINT = "https://api.spotify.com/v1"

        // 請記得到 “https://developer.spotify.com/console/get-artist-albums” 取得新的 "Oauth Token"
        private const val TOKEN =
            "BQCgD_msnDnxIN56exd3KhFDX1t_AV3b7hT4hj4E1KPoW0znlFXeB0vLotz0ESw0ELE2h8zFyr4IOb-lW7UtW-T0Y-7cdQjinteRQBCFtDEfJ9uViIYl5ekeVk7-pnAmiGphZ9qWGM4O50csTwGfBqttSICUZrGt0Ts"
    }

    private val httpClient = HttpClient {
        defaultRequest {
            header("Authorization", "Bearer ${TOKEN}")
        }
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getAlbums(): Albums {
        val artistId = "3fMbdgg4jU18AjLCKBhRSm" // Michael Jackson
        val endpoint = SPOTIFY_ENDPOINT + "/artists/${artistId}/albums"
        return httpClient.get(endpoint)
    }

}
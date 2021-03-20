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
            "BQBuJZU-u-EfeJtC7tIweLCDkhVrurq6ce4_gDGarZ4t6YI-5eGThx0TngKJkzSyFH6-cEei65RZnW5VdslzdOuAysaeX2HzteyafKmcihnHfmsqVMucI5mLShB2BzkCadpuPFvm2EkDhGdplhQYdDPaGr0EAdHInNc"
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
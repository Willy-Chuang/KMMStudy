package com.willychuang.kmmstudy.shared.module

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Albums(
    @SerialName("total")
    val total: Int,
    @SerialName("items")
    val list: List<Album>
)

@Serializable
data class Album(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("uri")
    val uri: String,
    @SerialName("external_urls")
    val extUrls: AlbumExtUrls,
    @SerialName("images")
    val images: List<AlbumImage>
)

@Serializable
data class AlbumExtUrls(
    @SerialName("spotify")
    val spotify: String
)

@Serializable
data class AlbumImage(
    @SerialName("height")
    val height: Int,
    @SerialName("url")
    val url: String,
    @SerialName("width")
    val width: Int
)


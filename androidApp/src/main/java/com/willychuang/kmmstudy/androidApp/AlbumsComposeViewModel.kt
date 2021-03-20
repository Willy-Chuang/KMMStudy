package com.willychuang.kmmstudy.androidApp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.willychuang.kmmstudy.shared.GdgLogger
import com.willychuang.kmmstudy.shared.module.Album
import com.willychuang.kmmstudy.shared.module.Albums
import com.willychuang.kmmstudy.shared.service.SpotifyService
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.logging.Logger

class AlbumsComposeViewModel: ViewModel() {

    private val _albums = MutableLiveData<List<Album>>()
    val albums : LiveData<List<Album>>
        get() = _albums

    private val service = SpotifyService()

    fun getAlbums(){
        viewModelScope.launch {
            kotlin.runCatching {
                service.getAlbums()
            }.onSuccess {albums ->
                albums?.let{
                    _albums.value = it.list
                }
            }.onFailure {
            }

        }
    }
}
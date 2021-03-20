package com.willychuang.kmmstudy.androidApp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.willychuang.kmmstudy.shared.module.Album

class AlbumsComposeActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            GetAlbumList()
        }
    }
}

@Composable
fun AlbumView(album: Album){
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "專輯名稱 ${album.name}", Modifier.padding(8.dp))
            Text(text = "發行日期 ${album.releaseDate}", Modifier.padding(8.dp))
        }
    }
}

@Composable
fun GetAlbumList(){

    val vm : AlbumsComposeViewModel = viewModel()
    val albums: State<List<Album>?> = vm.albums.observeAsState()

    vm.getAlbums()
    albums.value?.let {
        LazyColumn{ items(it) {
            AlbumView(album = it)
        }

        }
    }
}


//@Preview
//@Composable
//fun ShowPreview(){
//    AlbumView()
//}
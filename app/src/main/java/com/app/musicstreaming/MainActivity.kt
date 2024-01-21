package com.app.musicstreaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.musicstreaming.data.songsList
import com.app.musicstreaming.ui.screens.HomeScreen
import com.app.musicstreaming.ui.theme.MusicStreamingAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicStreamingAppTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        title = { Text(text = "Music Streaming App") }
                    )
                }) { innerPadding ->
                    HomeScreen(songsList = songsList,innerPadding)
                }
            }
        }
    }

}

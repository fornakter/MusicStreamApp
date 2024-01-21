import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Slider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.musicstreaming.data.Song
import com.app.musicstreaming.data.songsList
import com.app.musicstreaming.ui.helper.SongHelper
import kotlinx.coroutines.launch

@Composable
fun MediaPlayerCard(modifier: Modifier = Modifier, song: Song) {
        var songState by remember { mutableStateOf(false) }
        if(songState) {

        SongHelper.playStream(song.media)
        } else {
        SongHelper.pauseStream()
        }
        Card(
                modifier = modifier,
                elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp)
        ) {
        Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
        AsyncImage(
        model = song.imageUrl,
        contentDescription = "Song thumbnail",
        modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
        Text(
        text = song.title,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
        )
        Text(
        text = song.artist,
        fontSize = 12.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
        )
        }
        Icon(
        imageVector = if (songState) {
        Icons.Filled.Add
        } else {
        Icons.Filled.PlayArrow
        },
        contentDescription = "Play/Pause",
        modifier = Modifier.clickable {
        songState = !songState
        })
        }
        }

        DisposableEffect(song.media){
        onDispose {
        songState = false
        SongHelper.releasePlayer()
        }
        }

        }

@Preview(showBackground = true)
@Composable
fun MediaPlayerCardPreview() {
        MediaPlayerCard(
        song = songsList[0],
        )
        }
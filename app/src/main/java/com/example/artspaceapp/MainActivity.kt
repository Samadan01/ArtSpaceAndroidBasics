package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtworkApp()
                }
            }
        }
    }
}

@Composable
fun ArtTextAndImage(
    painterFile: Int,
    contentImageName: Int,
    artTitle: Int,
    artistAndYear: Int,
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit,
    modifier: Modifier = Modifier ){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row{
            Image(
                painter = painterResource(id = painterFile),
                contentDescription = stringResource(id = contentImageName),

            )

        }
        Row {
                Column (
                    modifier = modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(text = stringResource(id = artTitle),
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Text(text = stringResource(id = artistAndYear),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
        }
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Button(
                onClick = onPreviousClick,
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentSize(Alignment.TopStart)
            ) {
                Text(text = stringResource(id = R.string.previous))
            }
            Spacer(modifier = Modifier.width(125.dp))
            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentSize(Alignment.BottomEnd)
                ) {
                Text(text = stringResource(id = R.string.next_slide))
            }


        }

    }
}
@Composable
fun ArtWorkMain(){
    var monitorPage by remember { mutableIntStateOf(1) }

    when (monitorPage){
        1 -> {
            ArtTextAndImage(
                painterFile = R.drawable.lemon_tree,
                contentImageName = R.string.the_lemon_tree,
                artTitle = R.string.artwork_title_1,
                artistAndYear = R.string.artwork_artist_year_1,
                onNextClick = {
                    monitorPage = 2 },
                onPreviousClick = {
                    monitorPage = 4 }
            )
        }
        2 -> {
            ArtTextAndImage(
                painterFile = R.drawable.lemon_squeeze,
                contentImageName = R.string.the_lemon,
                artTitle = R.string.artwork_title_2,
                artistAndYear = R.string.artwork_artist_year_2,
                onNextClick = {
                    monitorPage = 3 },
                onPreviousClick = {
                    monitorPage = 1 }
            )
        }
        3 -> {
            ArtTextAndImage(
                painterFile = R.drawable.lemon_drink,
                contentImageName = R.string.the_lemon_drink,
                artTitle = R.string.artwork_title_3,
                artistAndYear = R.string.artwork_artist_year_3,
                onNextClick = {
                    monitorPage = 4 },
                onPreviousClick = {
                    monitorPage = 2 }
            )
        }
        4 -> {
            ArtTextAndImage(
                painterFile = R.drawable.lemon_restart,
                contentImageName = R.string.the_lemon_empty,
                artTitle = R.string.artwork_title_4,
                artistAndYear = R.string.artwork_artist_year_4,
                onNextClick = {
                    monitorPage = 1 },
                onPreviousClick = {
                monitorPage = 3 })
        }
    }

}
@Preview(showBackground = true)
@Composable
fun ArtworkApp() {
    ArtSpaceAppTheme {
        ArtWorkMain()
    }
}
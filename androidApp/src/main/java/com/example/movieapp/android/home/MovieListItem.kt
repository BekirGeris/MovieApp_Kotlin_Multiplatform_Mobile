package com.example.movieapp.android.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.android.MyApplicationTheme
import com.example.movieapp.android.R
import com.example.movieapp.domein.model.Movie

@Composable
fun MoveListItem(
    modifier: Modifier,
    movie: Movie,
    onMovieClick: (Movie) -> Unit
) {
    Card(
        modifier = modifier
            .height(220.dp)
            .clickable { onMovieClick(movie) }
    ) {
        Column {
            Box(
                modifier = modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = movie.imageUrl, contentDescription = movie.title,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp))
                )
                Surface(
                    color = Color.Black.copy(alpha = 0.5f),
                    modifier = modifier.size(50.dp),
                    shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.play_button),
                        contentDescription = "",
                        modifier = modifier
                            .padding(12.dp)
                            .align(Alignment.Center)
                    )
                }

            }

            Column(
                modifier = modifier.padding(10.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = modifier.height(4.dp))

                Text(
                    text = movie.releaseDate,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}

@Preview
@Composable
fun MyComposableComponentPreview() {
    // Bileşeni önizlemek için kullanılan işlev
    MyApplicationTheme {
        MoveListItem(Modifier, Movie(1,"uhwfbıvwehfbıvh","uhwfbıvwehfbıvh","https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3QfQYECgu6DX5UUWCBvv1Fl0BAJ.jpg","uhwfbıvwehfbıvh")) {

        }
    }
}
package com.example.movieapp.android.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieAppBar(
    modifier: Modifier = Modifier,
    canNavigationBack: Boolean,
    currentScreen: Destination,
    onNavigationBack: () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = 4.dp,
        color = MaterialTheme.colors.primary
    ) {
        Row(
            modifier = modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(visible = canNavigationBack) {
                IconButton(onClick = {
                    onNavigationBack()
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, contentDescription = "Back",
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
            Spacer(modifier = modifier.width(4.dp))

            Text(
                text = currentScreen.title,
                style = MaterialTheme.typography.h5,
                modifier = modifier.padding(6.dp),
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}
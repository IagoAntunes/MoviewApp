package br.com.movieapp.movie_popular_feature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieRate(
    rate: Double,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
        .widthIn(max = 60.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Rate",
            tint = Color.Yellow,
            modifier = Modifier.size(12.dp),
        )
        Text(
            rate.toString(),
            style = MaterialTheme.typography.body1,
            color = Color.White,
            fontSize = 10.sp,
        )
    }
}

@Preview
@Composable
private fun MovieRatePreview() {
    MovieRate(4.5)
}
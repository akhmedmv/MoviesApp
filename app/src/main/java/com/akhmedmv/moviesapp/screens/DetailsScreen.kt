package com.akhmedmv.moviesapp.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.akhmedmv.moviesapp.MainViewModel
import com.akhmedmv.moviesapp.utils.HtmlText

@Composable
fun DetailsScreen(viewModel: MainViewModel, itemId: String) {
    val currentItem = viewModel.allMovies
        .observeAsState(listOf()).value
        .firstOrNull { it.id == itemId.toInt() }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 16.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                AsyncImage(
                    model = currentItem?.image?.medium,
                    contentDescription = null,
                    modifier = Modifier.size(512.dp)
                )
                Text(
                    text = currentItem?.name ?: "",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Rating: ${currentItem?.rating?.average.toString()}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Genre: ",
                        fontSize = 18.sp
                    )
                    val genres = currentItem?.genres?.take(2)?.joinToString(", ")
                    Text(
                        text = "$genres",
                        fontSize = 18.sp
                    )
                }
                HtmlText(
                    html = currentItem?.summary ?: "",
                    modifier = Modifier.padding(top = 10.dp),
                    fontSize = 18f
                )
            }
        }
    }
}
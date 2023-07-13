package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviesapp.model.Movie
import com.example.moviesapp.ui.theme.MoviesAppTheme
import com.example.moviesapp.view.MovieItem
import com.example.moviesapp.viewmodel.MovieViewModel

class MainActivity : ComponentActivity() {
    val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                        MovieList(movieList = movieViewModel.movieListResponse)
                    movieViewModel.getMovieList()
                }
            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Movie>){
    LazyColumn{
        itemsIndexed(items = movieList){index, item ->
            MovieItem(movie =  item)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoviesAppTheme {
        val movie = Movie("Rashmita Raut", "", desc = "Hi", category = "hello")
        MovieItem(movie = movie)

    }
}
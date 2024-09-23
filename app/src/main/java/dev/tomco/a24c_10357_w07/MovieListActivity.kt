package dev.tomco.a24c_10357_w07

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dev.tomco.a24c_10357_w07.adapters.MovieAdapter
import dev.tomco.a24c_10357_w07.interfaces.MovieCallback
import dev.tomco.a24c_10357_w07.models.Movie
import dev.tomco.a24c_10357_w07.databinding.ActivityListMovieBinding
import dev.tomco.a24c_10357_w07.utilities.DataManager

class MovieListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListMovieBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var moviesRef: DatabaseReference
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moviesRef = initDBConnection("movies")
//        moviesRef.setValue(DataManager.generateMovieList())
        moviesRef.addListenerForSingleValueEvent(object :
            ValueEventListener { // For realtime data fetching from DB
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<List<Movie>>()

                if (value != null) {
                    movieAdapter.movies = value
                    movieAdapter.notifyDataSetChanged()
                }
                else
                    movieAdapter = MovieAdapter(emptyList())
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Data Error", "Failed to read value.", error.toException())
            }
        })
        movieAdapter = MovieAdapter()
        movieAdapter.movieCallback = object : MovieCallback {
            override fun favoriteButtonClicked(movie: Movie, position: Int) {
                movie.isFavorite = !movie.isFavorite
                moviesRef.child(position.toString())
                    .child("favorite")
                    .setValue(movie.isFavorite)
                movieAdapter.notifyItemChanged(position)
            }
        }
        binding.mainRVList.adapter = movieAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        binding.mainRVList.layoutManager = linearLayoutManager

    }

    private fun initDBConnection(path: String): DatabaseReference {
        database = Firebase.database
        return database.getReference(path)
    }
}
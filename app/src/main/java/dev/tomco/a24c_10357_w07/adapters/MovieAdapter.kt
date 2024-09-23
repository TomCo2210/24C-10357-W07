package dev.tomco.a24c_10357_w07.adapters

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.tomco.a24c_10357_w07.utilities.ImageLoader
import dev.tomco.a24c_10357_w07.utilities.TimeFormatter
import dev.tomco.a24c_10357_w07.R
import dev.tomco.a24c_10357_w07.databinding.HorizontalMovieItemBinding
import dev.tomco.a24c_10357_w07.interfaces.MovieCallback
import dev.tomco.a24c_10357_w07.models.Movie
import dev.tomco.a24c_10357_w07.utilities.Constants
import java.time.format.DateTimeFormatter
import java.util.function.Consumer
import kotlin.math.max

class MovieAdapter(
    var movies: List<Movie> = listOf(Movie.Builder()
        .name("No Data Yet..")
        .build())
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movieCallback: MovieCallback? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = HorizontalMovieItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun getItem(position: Int) = movies.get(position)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        with(holder) {
            with(movies.get(position)) {
                binding.movieLBLTitle.text = name
                binding.movieLBLYear.text = releaseDate
                binding.movieLBLDuration.text = TimeFormatter.formatTime(length)
                binding.movieLBLGenres.text = genre.joinToString(", ")
                binding.movieLBLActors.text = actors.joinToString(", ")
                binding.movieLBLOverview.text = overview
                binding.moveRTNGRating.rating = rating / 2
                ImageLoader.getInstance().load(poster, binding.movieIMGPoster)
                if (isFavorite) binding.movieIMGFavorite.setImageResource(R.drawable.heart)
                else binding.movieIMGFavorite.setImageResource(R.drawable.empty_heart)
                binding.movieCVData.setOnClickListener {
                    val animatorSet = ArrayList<ObjectAnimator>()
                    if (isCollapsed) {
                        animatorSet
                            .add(
                                ObjectAnimator
                                    .ofInt(
                                        binding.movieLBLActors,
                                        "maxLines",
                                        binding.movieLBLActors.lineCount
                                    ).setDuration(
                                        (max(
                                            (binding.movieLBLActors.lineCount - Constants.Animation.ACTORS_LIST_MIN_LINE).toDouble(),
                                            0.0
                                        ) * 50L).toLong()
                                    )
                            )
                        animatorSet
                            .add(
                                ObjectAnimator
                                    .ofInt(
                                        binding.movieLBLOverview,
                                        "maxLines",
                                        binding.movieLBLOverview.lineCount
                                    ).setDuration(
                                        (max(
                                            (binding.movieLBLOverview.lineCount - Constants.Animation.OVWERVIEW_MIN_LINES).toDouble(),
                                            0.0
                                        ) * 50L).toLong()
                                    )
                            )
                    } else {
                        animatorSet
                            .add(
                                ObjectAnimator
                                    .ofInt(
                                        binding.movieLBLActors,
                                        "maxLines",
                                        Constants.Animation.ACTORS_LIST_MIN_LINE
                                    ).setDuration(
                                        (max(
                                            (binding.movieLBLActors.lineCount - Constants.Animation.ACTORS_LIST_MIN_LINE).toDouble(),
                                            0.0
                                        ) * 50L).toLong()
                                    )
                            )
                        animatorSet
                            .add(
                                ObjectAnimator
                                    .ofInt(
                                        binding.movieLBLOverview,
                                        "maxLines",
                                        Constants.Animation.OVWERVIEW_MIN_LINES
                                    ).setDuration(
                                        (max(
                                            (binding.movieLBLOverview.lineCount - Constants.Animation.OVWERVIEW_MIN_LINES).toDouble(),
                                            0.0
                                        ) * 50L).toLong()
                                    )
                            )
                    }
                    toggleCollapse()
                    animatorSet.forEach(Consumer { obj: ObjectAnimator -> obj.start() })
                }
            }
        }
    }

    inner class MovieViewHolder(val binding: HorizontalMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.movieIMGFavorite.setOnClickListener {
                if (movieCallback != null)
                    movieCallback!!.favoriteButtonClicked(
                        getItem(adapterPosition),
                        adapterPosition
                    )
            }
        }
    }
}
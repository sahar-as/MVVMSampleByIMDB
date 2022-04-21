package ir.saharapps.mvvmsamplebyimdb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.saharapps.mvvmsamplebyimdb.R;
import ir.saharapps.mvvmsamplebyimdb.databinding.RvMovieItemBinding;
import ir.saharapps.mvvmsamplebyimdb.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private List<Movie>  movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RvMovieItemBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.rv_movie_item, parent, false);
        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.binding.txtRvMovieItemName.setText(movieList.get(position).getName());
        Picasso.get()
                .load(movieList.get(position)
                .getImgURL())
                .into(holder.binding.imgRvMovieItemImage);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{
        private RvMovieItemBinding binding;
        public MovieHolder(@NonNull RvMovieItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

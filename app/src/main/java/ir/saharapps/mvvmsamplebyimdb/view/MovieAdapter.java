package ir.saharapps.mvvmsamplebyimdb.view;

import android.util.Log;
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
import ir.saharapps.mvvmsamplebyimdb.viewModel.AppViewModel;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private static final String TAG = "MovieAdapter";

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
        int thisPosition = position;

        holder.binding.txtRvMovieItemName.setText(movieList.get(thisPosition).getName());

        String imageUrl = movieList.get(thisPosition).getImgURL();
        Log.d(TAG, "onBindViewHolder: 4444444444 " + imageUrl);
        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.no_image)
                .into(holder.binding.imgRvMovieItemImage);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 66666666666666");
                AppViewModel appViewModel = new AppViewModel();
                appViewModel.getMovieDetail(movieList.get(thisPosition).getId());
            }
        };

        holder.binding.imgRvMovieItemImage.setOnClickListener(onClickListener);
        holder.binding.txtRvMovieItemName.setOnClickListener(onClickListener);
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

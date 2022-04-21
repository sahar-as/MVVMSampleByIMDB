package ir.saharapps.mvvmsamplebyimdb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ir.saharapps.mvvmsamplebyimdb.databinding.ActivityMainBinding;
import ir.saharapps.mvvmsamplebyimdb.model.Movie;
import ir.saharapps.mvvmsamplebyimdb.viewModel.AppViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        AppViewModel appViewModel;
        appViewModel = new ViewModelProvider(this).get(AppViewModel.class);
        binding.setAppViewModel(appViewModel);
        binding.setLifecycleOwner(this);

//        MovieAdapter adapter = new MovieAdapter(movieList);
//        binding.rvMainActivityMovieList.setLayoutManager(new GridLayoutManager(this, 2));
//        binding.rvMainActivityMovieList.setAdapter(adapter);

        try{
            appViewModel.mutableLiveDataMovieList.observe(this, new Observer<List<Movie>>() {
                @Override
                public void onChanged(List<Movie> movies) {
                    Log.d(TAG, "onChanged: 22222222");
                    movieList = new ArrayList<>(movies);
                    MovieAdapter adapter = new MovieAdapter(movieList);
                    binding.rvMainActivityMovieList.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                    binding.rvMainActivityMovieList.setAdapter(adapter);
                }
            });
        }catch (NullPointerException e){
            Log.d(TAG, "onCreate: 333333333333333");
        }





    }
}
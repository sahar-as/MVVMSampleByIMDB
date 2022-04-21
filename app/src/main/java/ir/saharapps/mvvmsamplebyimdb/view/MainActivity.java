package ir.saharapps.mvvmsamplebyimdb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

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

        binding.progressBarMainActivity.setVisibility(View.GONE);

        //this is for data adapter and recyclerView
        try{
            appViewModel.liveMovieList.observe(this, new Observer<List<Movie>>() {
                @Override
                public void onChanged(List<Movie> movies) {
                    Log.d(TAG, "onChanged: 22222222");
                    movieList = new ArrayList<>(movies);
                    MovieAdapter adapter = new MovieAdapter(movieList, MainActivity.this,MainActivity.this);
                    binding.rvMainActivityMovieList.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                    binding.rvMainActivityMovieList.setAdapter(adapter);
                }
            });
        }catch (NullPointerException e){
            Log.d(TAG, "onCreate: 333333333333333");
        }

        //This is for show/hide progress bar
        appViewModel.liveProgressBar.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    binding.progressBarMainActivity.setVisibility(View.VISIBLE);
                }else{
                    binding.progressBarMainActivity.setVisibility(View.GONE);
                }
            }
        });





    }
}
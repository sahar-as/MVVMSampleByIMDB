package ir.saharapps.mvvmsamplebyimdb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import ir.saharapps.mvvmsamplebyimdb.databinding.ActivityMainBinding;
import ir.saharapps.mvvmsamplebyimdb.model.Movie;
import ir.saharapps.mvvmsamplebyimdb.viewModel.AppViewModel;

public class MainActivity extends AppCompatActivity {

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

        List<Movie> movieList;
        MovieAdapter adapter = new MovieAdapter(movieList);

    }
}
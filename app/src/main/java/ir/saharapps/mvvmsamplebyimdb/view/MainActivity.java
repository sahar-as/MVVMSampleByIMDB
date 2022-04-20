package ir.saharapps.mvvmsamplebyimdb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import ir.saharapps.mvvmsamplebyimdb.databinding.ActivityMainBinding;
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

    }
}
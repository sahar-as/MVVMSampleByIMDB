package ir.saharapps.mvvmsamplebyimdb.viewModel;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import ir.saharapps.mvvmsamplebyimdb.model.GetMovieInfo;
import ir.saharapps.mvvmsamplebyimdb.model.Movie;

public class AppViewModel extends ViewModel {
    private static final String TAG = "AppViewModel";

    public ObservableField<String> cityName =  new ObservableField<>("");


    public void getMovies(){
        Log.d(TAG, "getMovies: pppppppppppppppp");
        GetMovieInfo mGetMovieInfo = new GetMovieInfo();
        mGetMovieInfo.getMovieNameImage(cityName.get(), new GetMovieInfo.ResultListener() {
            @Override
            public void nameResult(JsonArray jsonArray) {
                List<Movie> movieList = new ArrayList<>();
                Log.d(TAG, "nameResult: RRRRRRRRRRRRRRRR " + jsonArray);
                for(int i=0; i<jsonArray.size() ; i++){
                    JsonObject oneMovie = (JsonObject) jsonArray.get(i);
                    Movie movie = new Movie(oneMovie.get("title").toString(),oneMovie.get("image").toString());
                    movieList.add(movie);
                }
                for(int j=0; j<movieList.size(); j++){
                    Log.d(TAG, "nameResult: 111111111 " + movieList.get(j).toString());
                }
            }

            @Override
            public void detailResult() {

            }
        });
    }

}
